package org.recrypt.wallet.ui.fragment.wallet_fragment.light;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.recrypt.wallet.R;
import org.recrypt.wallet.model.gson.history.History;
import org.recrypt.wallet.ui.fragment.wallet_fragment.ProgressBarHolder;
import org.recrypt.wallet.ui.fragment.wallet_fragment.TransactionAdapter;
import org.recrypt.wallet.ui.fragment.wallet_fragment.TransactionClickListener;

import java.util.List;

public class TransactionAdapterLight extends TransactionAdapter {

    public TransactionAdapterLight(List<History> historyList, TransactionClickListener listener) {
        super(historyList, listener);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_TRANSACTION) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            View view = layoutInflater.inflate(R.layout.item_transaction_light, parent, false);
            return new TransactionHolderLight(view, listener);
        } else {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            View view = layoutInflater.inflate(R.layout.item_progress_bar, parent, false);
            return new ProgressBarHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ProgressBarHolder) {
            ((ProgressBarHolder) holder).bindProgressBar(mLoadingFlag);
        } else {
            mHistory = mHistoryList.get(position);
            ((TransactionHolderLight) holder).bindTransactionData(mHistory);
        }
    }
}
