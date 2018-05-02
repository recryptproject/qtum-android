package org.recrypt.wallet.ui.fragment.my_contracts_fragment;

import android.content.Context;

import org.recrypt.wallet.dataprovider.rest_api.recrypt.RecryptService;
import org.recrypt.wallet.datastorage.RecryptSettingSharedPreference;
import org.recrypt.wallet.datastorage.TinyDB;
import org.recrypt.wallet.model.contract.Contract;
import org.recrypt.wallet.model.contract.Token;
import org.recrypt.wallet.model.gson.ExistContractResponse;

import java.lang.ref.WeakReference;
import java.util.List;

import rx.Observable;

public class MyContractsInteractorImpl implements MyContractsInteractor {
    private WeakReference<Context> mContext;

    public MyContractsInteractorImpl(Context context) {
        mContext = new WeakReference<>(context);
    }

    @Override
    public List<Contract> getContracts() {
        TinyDB tinyDB = new TinyDB(mContext.get());
        return tinyDB.getContractList();
    }

    @Override
    public List<Contract> getContractsWithoutTokens() {
        TinyDB tinyDB = new TinyDB(mContext.get());
        return tinyDB.getContractListWithoutToken();
    }

    @Override
    public List<Token> getTokens() {
        TinyDB tinyDB = new TinyDB(mContext.get());
        return tinyDB.getTokenList();
    }

    @Override
    public void setContractWithoutTokens(List<Contract> contracts) {
        TinyDB tinyDB = new TinyDB(mContext.get());
        tinyDB.putContractListWithoutToken(contracts);
    }

    @Override
    public void setTokens(List<Token> tokens) {
        TinyDB tinyDB = new TinyDB(mContext.get());
        tinyDB.putTokenList(tokens);
    }

    @Override
    public boolean isShowWizard() {
        RecryptSettingSharedPreference recryptSettingSharedPreference = new RecryptSettingSharedPreference();
        return recryptSettingSharedPreference.getShowContractsDeleteUnsubscribeWizard(mContext.get());
    }

    @Override
    public void setShowWizard(boolean isShow) {
        RecryptSettingSharedPreference recryptSettingSharedPreference = new RecryptSettingSharedPreference();
        recryptSettingSharedPreference.setShowContractsDeleteUnsubscribeWizard(mContext.get(), isShow);
    }

    @Override
    public Observable<ExistContractResponse> isContractExist(String contractAddress) {
        return RecryptService.newInstance().isContractExist(contractAddress);
    }
}
