package org.recrypt.wallet.ui.fragment.addresses_fragment;

import org.bitcoinj.crypto.DeterministicKey;
import org.recrypt.wallet.ui.base.base_fragment.BaseFragmentView;

import java.util.List;

public interface AddressesView extends BaseFragmentView {
    void updateAddressList(List<DeterministicKey> deterministicKeys);

    void setAdapterNull();
}
