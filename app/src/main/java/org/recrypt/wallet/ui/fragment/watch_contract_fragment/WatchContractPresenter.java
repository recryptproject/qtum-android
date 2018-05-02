package org.recrypt.wallet.ui.fragment.watch_contract_fragment;

import org.recrypt.wallet.model.ContractTemplate;
import org.recrypt.wallet.ui.base.base_fragment.BaseFragmentPresenter;

public interface WatchContractPresenter extends BaseFragmentPresenter {
    void onOkClick(String name, String address, String ABIInterface);

    void onTemplateClick(ContractTemplate contractTemplate);
}
