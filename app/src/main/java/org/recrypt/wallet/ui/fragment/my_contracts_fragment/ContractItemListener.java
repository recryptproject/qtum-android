package org.recrypt.wallet.ui.fragment.my_contracts_fragment;

import org.recrypt.wallet.model.contract.Contract;

public interface ContractItemListener {
    void onUnsubscribeClick(Contract contract);
}
