package org.recrypt.wallet.ui.fragment.token_cash_management_fragment;

import org.recrypt.wallet.model.DeterministicKeyWithTokenBalance;

public interface OnAddressTokenClickListener {
    void onItemClick(DeterministicKeyWithTokenBalance item);
}
