package org.recrypt.wallet.ui.fragment.start_page_fragment;

import android.content.Context;

import org.recrypt.wallet.datastorage.HistoryList;
import org.recrypt.wallet.datastorage.KeyStorage;
import org.recrypt.wallet.datastorage.RecryptSharedPreference;
import org.recrypt.wallet.datastorage.TinyDB;

import java.lang.ref.WeakReference;

public class StartPageInteractorImpl implements StartPageInteractor {

    private WeakReference<Context> mContext;

    public StartPageInteractorImpl(Context context) {
        mContext = new WeakReference<>(context);
    }

    @Override
    public boolean getGeneratedKey() {
        return RecryptSharedPreference.getInstance().getKeyGeneratedInstance(mContext.get());
    }

    @Override
    public void clearWallet() {
        RecryptSharedPreference.getInstance().clear(mContext.get());
        KeyStorage.getInstance().clearKeyStorage();
        HistoryList.getInstance().clearHistoryList();
        TinyDB db = new TinyDB(mContext.get());
        db.clearTokenList();
        db.clearContractList();
        db.clearTemplateList();
    }
}
