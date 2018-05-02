package org.recrypt.wallet.ui.fragment.watch_contract_fragment;

import org.recrypt.wallet.model.ContractTemplate;
import org.recrypt.wallet.ui.base.base_fragment.BaseFragment;
import org.recrypt.wallet.ui.base.base_fragment.BaseFragmentView;

import java.util.List;

public interface WatchContractView extends BaseFragmentView {
    void setABIInterface(String name, String abiInterface);

    void setUpTemplatesList(List<ContractTemplate> contractTemplateList, OnTemplateClickListener listener);

    void notifyAdapter(int adapterPosition);

    OnTemplateClickListener getTemplateClickListener();

    BaseFragment.AlertDialogCallBack getAlertCallback();
}
