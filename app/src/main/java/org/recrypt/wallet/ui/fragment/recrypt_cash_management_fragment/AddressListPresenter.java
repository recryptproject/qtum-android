package org.recrypt.wallet.ui.fragment.recrypt_cash_management_fragment;

import org.recrypt.wallet.model.AddressWithBalance;
import org.recrypt.wallet.ui.base.base_fragment.BaseFragmentPresenter;

import java.util.List;

public interface AddressListPresenter extends BaseFragmentPresenter {
    AddressWithBalance getKeyWithBalanceFrom();

    void setKeyWithBalanceFrom(AddressWithBalance keyWithBalanceFrom);

    List<AddressWithBalance> getAddressWithBalanceList();
}
