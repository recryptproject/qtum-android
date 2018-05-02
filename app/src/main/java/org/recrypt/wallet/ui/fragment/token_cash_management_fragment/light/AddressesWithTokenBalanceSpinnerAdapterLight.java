package org.recrypt.wallet.ui.fragment.token_cash_management_fragment.light;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;

import org.recrypt.wallet.R;
import org.recrypt.wallet.model.DeterministicKeyWithTokenBalance;
import org.recrypt.wallet.ui.fragment.token_cash_management_fragment.AddressesWithTokenBalanceSpinnerAdapter;

import java.util.List;

public class AddressesWithTokenBalanceSpinnerAdapterLight extends AddressesWithTokenBalanceSpinnerAdapter {

    public AddressesWithTokenBalanceSpinnerAdapterLight(@NonNull Context context, List<DeterministicKeyWithTokenBalance> keyWithBalanceList, String currency, int decimalUnits) {
        super(context, keyWithBalanceList, currency, decimalUnits);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return getCustomView(position, R.layout.item_address_spinner_light, parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return getCustomView(position, R.layout.item_address_spinner_dropdown_light, parent);
    }
}
