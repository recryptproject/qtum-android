package org.recrypt.wallet.ui.fragment.templates_fragment;

import org.recrypt.wallet.model.ContractTemplate;
import org.recrypt.wallet.ui.base.base_fragment.BaseFragmentView;

import java.util.List;

public interface TemplatesView extends BaseFragmentView {
    void setUpTemplateList(List<ContractTemplate> contractTemplateList);
}
