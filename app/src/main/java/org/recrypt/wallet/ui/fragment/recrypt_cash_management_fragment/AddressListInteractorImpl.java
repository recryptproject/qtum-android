package org.recrypt.wallet.ui.fragment.recrypt_cash_management_fragment;

import android.content.Context;

import org.recrypt.wallet.dataprovider.rest_api.recrypt.RecryptService;
import org.recrypt.wallet.datastorage.KeyStorage;

import org.recrypt.wallet.model.gson.UnspentOutput;

import java.lang.ref.WeakReference;
import java.util.List;

import rx.Observable;

public class AddressListInteractorImpl implements AddressListInteractor {

    private WeakReference<Context> mContext;

    AddressListInteractorImpl(Context context) {
        mContext = new WeakReference<Context>(context);
    }

    @Override
    public List<String> getAddresses() {
        return KeyStorage.getInstance().getAddresses();
    }

    @Override
    public Observable<List<UnspentOutput>> getUnspentOutputs(List<String> addresses) {
        return RecryptService.newInstance().getUnspentOutputsForSeveralAddresses(addresses);
    }
}
