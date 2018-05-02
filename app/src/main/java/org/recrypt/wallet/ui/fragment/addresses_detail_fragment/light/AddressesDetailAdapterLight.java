package org.recrypt.wallet.ui.fragment.addresses_detail_fragment.light;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.recrypt.wallet.model.gson.history.TransactionInfo;
import org.recrypt.wallet.ui.fragment.addresses_detail_fragment.AddressesDetailAdapter;
import org.recrypt.wallet.ui.fragment.addresses_detail_fragment.AddressesDetailHolder;

import java.util.List;

class AddressesDetailAdapterLight<T extends TransactionInfo> extends AddressesDetailAdapter {

    protected AddressesDetailAdapterLight(List<T> transactionInfoList) {
        super(transactionInfoList);
    }

    @Override
    public AddressesDetailHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(org.recrypt.wallet.R.layout.item_transaction_detail_light, parent, false);
        return new AddressesDetailHolder(view);
    }
}
