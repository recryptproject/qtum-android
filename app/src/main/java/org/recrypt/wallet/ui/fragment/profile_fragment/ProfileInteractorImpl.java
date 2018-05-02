package org.recrypt.wallet.ui.fragment.profile_fragment;

import android.content.Context;

import org.recrypt.wallet.datastorage.HistoryList;
import org.recrypt.wallet.datastorage.KeyStorage;
import org.recrypt.wallet.datastorage.RecryptSharedPreference;
import org.recrypt.wallet.datastorage.TinyDB;
import org.recrypt.wallet.datastorage.listeners.LanguageChangeListener;

class ProfileInteractorImpl implements ProfileInteractor {

    private Context mContext;

    ProfileInteractorImpl(Context context) {
        mContext = context;
    }

    @Override
    public void clearWallet() {
        RecryptSharedPreference.getInstance().clear(mContext);
        KeyStorage.getInstance().clearKeyStorage();
        HistoryList.getInstance().clearHistoryList();
        TinyDB db = new TinyDB(mContext);
        db.clearTokenList();
        db.clearContractList();
        db.clearTemplateList();
    }

    @Override
    public void setupLanguageChangeListener(LanguageChangeListener listener) {
        RecryptSharedPreference.getInstance().addLanguageListener(listener);
    }

    @Override
    public void removeLanguageListener(LanguageChangeListener listener) {
        RecryptSharedPreference.getInstance().removeLanguageListener(listener);
    }

    @Override
    public boolean isTouchIdEnable() {
        return RecryptSharedPreference.getInstance().isTouchIdEnable(mContext);
    }

    @Override
    public void saveTouchIdEnable(boolean isChecked) {
        RecryptSharedPreference.getInstance().saveTouchIdEnable(mContext, isChecked);
    }
}
