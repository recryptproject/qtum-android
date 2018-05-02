package org.recrypt.wallet.ui.activity.main_activity;

import android.content.Context;

import org.recrypt.wallet.dataprovider.rest_api.recrypt.RecryptService;
import org.recrypt.wallet.datastorage.HistoryList;
import org.recrypt.wallet.datastorage.KeyStorage;
import org.recrypt.wallet.datastorage.RecryptSettingSharedPreference;
import org.recrypt.wallet.datastorage.RecryptSharedPreference;
import org.recrypt.wallet.datastorage.listeners.LanguageChangeListener;
import org.recrypt.wallet.model.gson.DGPInfo;
import org.recrypt.wallet.model.gson.FeePerKb;

import java.math.BigDecimal;

import rx.Observable;

class MainActivityInteractorImpl implements MainActivityInteractor {

    private Context mContext;

    private boolean isDGPInfoLoaded = false;
    private boolean isFeePerkbLoaded = false;

    MainActivityInteractorImpl(Context context) {
        mContext = context;
    }

    @Override
    public boolean getKeyGeneratedInstance() {
        return RecryptSharedPreference.getInstance().getKeyGeneratedInstance(mContext);
    }

    @Override
    public void clearStatic() {
        KeyStorage.getInstance().clearKeyStorage();
        HistoryList.getInstance().clearHistoryList();
    }

    @Override
    public Observable<DGPInfo> getDGPInfo() {
        return RecryptService.newInstance().getDGPInfo();
    }

    @Override
    public boolean isDGPInfoLoaded() {
        return isDGPInfoLoaded;
    }

    @Override
    public boolean isFeePerkbLoaded() {
        return isFeePerkbLoaded;
    }

    @Override
    public void addLanguageChangeListener(LanguageChangeListener languageChangeListener) {
        RecryptSharedPreference.getInstance().addLanguageListener(languageChangeListener);
    }

    @Override
    public void removeLanguageChangeListener(LanguageChangeListener languageChangeListener) {
        RecryptSharedPreference.getInstance().removeLanguageListener(languageChangeListener);
    }

    @Override
    public Observable<FeePerKb> getFeePerKb() {
        return RecryptService.newInstance().getEstimateFeePerKb(2);
    }

    @Override
    public void setDGPInfo(DGPInfo dgpInfo) {
        isDGPInfoLoaded = true;
        RecryptSharedPreference.getInstance().setMinGasPrice(mContext, dgpInfo.getMingasprice());
    }

    @Override
    public void setFeePerKb(FeePerKb feePerKb) {
        isFeePerkbLoaded = true;
        RecryptSettingSharedPreference recryptSettingSharedPreference = new RecryptSettingSharedPreference();
        recryptSettingSharedPreference.setFeePerKb(mContext, feePerKb.getFeePerKb().setScale(5, BigDecimal.ROUND_HALF_DOWN).toPlainString());
    }
}
