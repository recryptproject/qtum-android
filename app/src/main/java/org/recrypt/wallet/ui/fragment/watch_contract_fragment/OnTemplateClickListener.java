package org.recrypt.wallet.ui.fragment.watch_contract_fragment;

import org.recrypt.wallet.model.ContractTemplate;

public interface OnTemplateClickListener {
    void updateSelection(int adapterPosition);

    void onTemplateClick(ContractTemplate contractTemplate);
}
