package org.recrypt.wallet.ui.fragment.contract_management_fragment;

import org.recrypt.wallet.model.contract.Contract;
import org.recrypt.wallet.ui.base.base_fragment.BaseFragmentPresenter;

public interface ContractManagementPresenter extends BaseFragmentPresenter {
    Contract getContractByAddress(String contractAddress);
}
