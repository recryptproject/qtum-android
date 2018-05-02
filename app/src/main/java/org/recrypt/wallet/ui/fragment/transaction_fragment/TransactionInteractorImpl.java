package org.recrypt.wallet.ui.fragment.transaction_fragment;

import android.content.Context;

import org.recrypt.wallet.R;
import org.recrypt.wallet.model.gson.history.History;
import org.recrypt.wallet.datastorage.HistoryList;
import org.recrypt.wallet.utils.DateCalculator;

import java.lang.ref.WeakReference;

class TransactionInteractorImpl implements TransactionInteractor {

    private WeakReference<Context> mContext;

    public TransactionInteractorImpl(Context context) {
        this.mContext = new WeakReference<>(context);
    }

    @Override
    public History getHistory(int position) {
        return HistoryList.getInstance().getHistoryList().get(position);
    }

    @Override
    public String getFullDate(long l) {
        return DateCalculator.getFullDate(l);
    }

    @Override
    public String getUnconfirmedDate() {
        return mContext.get().getString(R.string.unconfirmed);
    }
}
