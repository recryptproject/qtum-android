package org.recrypt.wallet.ui.fragment.store_categories;

import android.content.Context;

import org.recrypt.wallet.dataprovider.rest_api.recrypt.RecryptService;
import org.recrypt.wallet.model.gson.QstoreContractType;

import java.lang.ref.WeakReference;
import java.util.List;

import rx.Observable;

public class StoreCategoriesInteractorImpl implements StoreCategoriesInteractor {
    private WeakReference<Context> mContext;

    public StoreCategoriesInteractorImpl(Context context) {
        mContext = new WeakReference<>(context);
    }

    @Override
    public Observable<List<QstoreContractType>> contractTypesObservable() {
        return RecryptService.newInstance().getContractTypes();
    }
}
