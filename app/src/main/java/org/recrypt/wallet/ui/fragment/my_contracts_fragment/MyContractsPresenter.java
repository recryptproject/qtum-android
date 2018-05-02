package org.recrypt.wallet.ui.fragment.my_contracts_fragment;

import org.recrypt.wallet.model.contract.Contract;
import org.recrypt.wallet.ui.base.base_fragment.BaseFragmentPresenter;

public interface MyContractsPresenter extends BaseFragmentPresenter {
    void onWizardClose();
    void onContractClick(Contract contract);
    void onUnsubscribeClick();
    void onRenameContract(Contract contract);
}
