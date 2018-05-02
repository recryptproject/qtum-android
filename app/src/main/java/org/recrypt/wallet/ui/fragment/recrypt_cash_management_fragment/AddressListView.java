package org.recrypt.wallet.ui.fragment.recrypt_cash_management_fragment;

import org.recrypt.wallet.model.AddressWithBalance;
import org.recrypt.wallet.ui.base.base_fragment.BaseFragmentView;

import java.util.List;

public interface AddressListView extends BaseFragmentView {
    void updateAddressList(List<AddressWithBalance> deterministicKeyWithBalance);
}
