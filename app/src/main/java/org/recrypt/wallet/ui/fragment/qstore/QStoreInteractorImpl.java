package org.recrypt.wallet.ui.fragment.qstore;

import android.content.Context;

import org.recrypt.wallet.R;
import org.recrypt.wallet.dataprovider.rest_api.recrypt.RecryptService;
import org.recrypt.wallet.model.gson.qstore.QSearchItem;
import org.recrypt.wallet.model.gson.qstore.QstoreItem;

import java.lang.ref.WeakReference;
import java.util.List;

import rx.Observable;

public class QStoreInteractorImpl implements QStoreInteractor {
    private WeakReference<Context> mContext;

    public QStoreInteractorImpl(Context context) {
        mContext = new WeakReference<>(context);
    }

    @Override
    public Observable<List<QSearchItem>> searchContracts(int searchOffset, String emptyType, String tag, boolean byTag) {
        return RecryptService.newInstance().searchContracts(searchOffset, emptyType, tag, byTag);

    }

    @Override
    public Observable<List<QstoreItem>> getWhatsNewObservable() {
        return RecryptService.newInstance().getWatsNew();
    }

    @Override
    public Observable<List<QstoreItem>> getTrendingNowObservable() {
        return RecryptService.newInstance()
                .getTrendingNow();
    }

    @Override
    public String getTrendingString() {
        return mContext.get().getString(R.string.trending_now);
    }

    @Override
    public String getWhatsNewString() {
        return mContext.get().getString(R.string.whats_new);
    }
}
