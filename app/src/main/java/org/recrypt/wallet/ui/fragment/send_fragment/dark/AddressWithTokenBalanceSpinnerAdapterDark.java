package org.recrypt.wallet.ui.fragment.send_fragment.dark;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;

import org.recrypt.wallet.R;
import org.recrypt.wallet.model.gson.token_balance.TokenBalance;
import org.recrypt.wallet.ui.fragment.send_fragment.AddressWithTokenBalanceSpinnerAdapter;


public class AddressWithTokenBalanceSpinnerAdapterDark extends AddressWithTokenBalanceSpinnerAdapter {

    public AddressWithTokenBalanceSpinnerAdapterDark(@NonNull Context context, TokenBalance tokenBalance, String currency, int decimalUnits) {
        super(context, tokenBalance, currency, decimalUnits);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return getCustomView(i, R.layout.item_address_spinner_send, viewGroup);
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getCustomViewDropDown(position, R.layout.item_address_spinner_dropdown_send, parent);
    }
}
