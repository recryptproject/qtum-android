package org.recrypt.wallet.ui.fragment.recrypt_cash_management_fragment;

import org.recrypt.wallet.model.AddressWithBalance;

public interface OnAddressClickListener {
    void onItemClick(AddressWithBalance deterministicKeyWithBalance);
}
