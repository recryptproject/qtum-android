package org.qtum.mromanovsky.qtum.ui.fragment.WalletFragment;


import android.content.Context;
import android.util.Log;

import org.qtum.mromanovsky.qtum.dataprovider.RestAPI.QtumService;

import org.qtum.mromanovsky.qtum.dataprovider.RestAPI.gsonmodels.History.History;
import org.qtum.mromanovsky.qtum.dataprovider.RestAPI.gsonmodels.History.HistoryResponse;
import org.qtum.mromanovsky.qtum.dataprovider.RestAPI.gsonmodels.History.Vin;
import org.qtum.mromanovsky.qtum.dataprovider.RestAPI.gsonmodels.History.Vout;
import org.qtum.mromanovsky.qtum.dataprovider.RestAPI.gsonmodels.UnspentOutput;
import org.qtum.mromanovsky.qtum.datastorage.KeyStorage;
import org.qtum.mromanovsky.qtum.datastorage.HistoryList;

import java.math.BigDecimal;
import java.util.List;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

class WalletFragmentInteractorImpl implements WalletFragmentInteractor {

    private Context mContext;
    private Subscription mSubscriptionHistoryList = null;
    private Subscription mSubscriptionBalance = null;

    WalletFragmentInteractorImpl(Context context){
        mContext = context;
    }

    @Override
    public List<History> getHistoryList() {
        return HistoryList.getInstance().getHistoryList();
    }


    @Override
    public void getHistoryList(final GetHistoryListCallBack callBack) {
        final List<String> addresses = KeyStorage.getInstance().getAddresses();
        mSubscriptionHistoryList = QtumService.newInstance()
                .getHistoryListForSeveralAddresses(addresses, 50,0)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<HistoryResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onError(e);
                    }

                    @Override
                    public void onNext(HistoryResponse historyResponse) {
                        //TODO : edit
//                        if(getHistoryList().size()!=0){
//                            if(getHistoryList().size()==historyList.size()){
//                                callBack.onSuccessWithoutChange();
//                                return;
//                            }
//                        }


                        for(History history : historyResponse.getItems()){
                            BigDecimal changeInBalance = calculateVout(history,addresses).subtract(calculateVin(history,addresses));
                            history.setChangeInBalance(changeInBalance.doubleValue());
                        }

                        HistoryList.getInstance().setHistoryList(historyResponse.getItems());
                        callBack.onSuccess();
                    }
                });

    }

    private BigDecimal calculateVin(History history, List<String> addresses){
        BigDecimal totalVin = new BigDecimal("0.0");
        for(Vin vin : history.getVin()){
            for(String address : addresses){
                if(vin.getAddress().equals(address)){
                    totalVin = new BigDecimal(history.getAmount());
                    return totalVin;
                }
            }
        }
        return totalVin;
    }

    private BigDecimal calculateVout(History history, List<String> addresses){
        BigDecimal totalVout = new BigDecimal("0.0");
        for(Vout vout : history.getVout()){
            for(String address : addresses){
                if(vout.getAddress().equals(address)){
                    totalVout = totalVout.add(new BigDecimal(vout.getValue()));
                }
            }
        }
        return totalVout;
    }

    @Override
    public void getBalance(final GetBalanceCallBack callBack) {
        mSubscriptionBalance = QtumService.newInstance()
                .getUnspentOutputsForSeveralAddresses(KeyStorage.getInstance().getAddresses())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<UnspentOutput>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(List<UnspentOutput> unspentOutputs) {
                        double balance = 0.0;
                        for(UnspentOutput unspentOutput : unspentOutputs){
                            balance+=unspentOutput.getAmount();
                        }
                        HistoryList.getInstance().setBalance(balance);
                        callBack.onSuccess(balance);
                    }
                });
    }

    void unSubscribe(){
        if(mSubscriptionHistoryList != null){
            mSubscriptionHistoryList.unsubscribe();
        }
        if(mSubscriptionBalance != null){
            mSubscriptionBalance.unsubscribe();
        }
    }

    interface GetHistoryListCallBack {
        void onSuccess();
        void onError(Throwable e);
    }

    interface GetBalanceCallBack {
        void onSuccess(double balance);
    }

    @Override
    public String getAddress() {
        return KeyStorage.getInstance().getCurrentAddress();
    }
}