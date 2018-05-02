package org.recrypt.wallet.ui.fragment.template_library_fragment;

import org.recrypt.wallet.model.ContractTemplate;
import org.recrypt.wallet.ui.base.base_fragment.BaseFragmentView;

import java.util.List;

public interface TemplateLibraryView extends BaseFragmentView {

    void setUpTemplateList(List<ContractTemplate> contractTemplateList);

}
