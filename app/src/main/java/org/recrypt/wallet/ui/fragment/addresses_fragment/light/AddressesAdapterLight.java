package org.recrypt.wallet.ui.fragment.addresses_fragment.light;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.recrypt.wallet.R;
import org.recrypt.wallet.ui.fragment.addresses_fragment.AddressHolder;
import org.recrypt.wallet.ui.fragment.addresses_fragment.AddressesAdapter;
import org.recrypt.wallet.ui.fragment.addresses_fragment.OnAddressClickListener;
import org.recrypt.wallet.utils.CurrentNetParams;
import org.bitcoinj.crypto.DeterministicKey;

import java.util.List;

public class AddressesAdapterLight extends AddressesAdapter {

    public AddressesAdapterLight(List<DeterministicKey> deterministicKeys, OnAddressClickListener listener) {
        super(deterministicKeys, listener);
    }

    @Override
    public AddressHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_single_checkable_light, parent, false);
        return new AddressHolderLight(view, listener);
    }

    @Override
    public void onBindViewHolder(AddressHolder holder, int position) {
        mAddress = mDeterministicKeys.get(position).toAddress(CurrentNetParams.getNetParams()).toString();
        ((AddressHolderLight) holder).bindAddress(mAddress, position);
    }
}