package org.recrypt.wallet.ui.fragment.token_cash_management_fragment.dark;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;

import org.recrypt.wallet.R;
import org.recrypt.wallet.model.DeterministicKeyWithTokenBalance;
import org.recrypt.wallet.ui.fragment.token_cash_management_fragment.AddressesWithTokenBalanceSpinnerAdapter;

import java.util.List;

public class AddressesWithTokenBalanceSpinnerAdapterDark extends AddressesWithTokenBalanceSpinnerAdapter {

    public AddressesWithTokenBalanceSpinnerAdapterDark(@NonNull Context context, List<DeterministicKeyWithTokenBalance> keyWithBalanceList, String currency, int decimalUnits) {
        super(context, keyWithBalanceList, currency, decimalUnits);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return getCustomView(position, R.layout.item_address_spinner, parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return getCustomView(position, R.layout.item_address_spinner_dropdown, parent);
    }
}
