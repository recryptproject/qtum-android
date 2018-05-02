package org.recrypt.wallet.ui.fragment.confirm_passphrase_fragment;


import android.content.Context;

import org.recrypt.wallet.datastorage.KeyStorage;
import org.recrypt.wallet.datastorage.RecryptSharedPreference;

import java.lang.ref.WeakReference;

import rx.Observable;

public class ConfirmPassphraseInteractorImpl implements ConfirmPassphraseInteractor {

    WeakReference<Context> mContext;

    ConfirmPassphraseInteractorImpl(Context context){
        mContext = new WeakReference<Context>(context);
    }

    @Override
    public Observable<String> createWallet(String passphrase) {
        return KeyStorage.getInstance().createWallet(passphrase);
    }

    @Override
    public void setKeyGeneratedInstance(boolean isKeyGenerated) {
        RecryptSharedPreference.getInstance().setKeyGeneratedInstance(mContext.get(), isKeyGenerated);
    }
}
