package org.recrypt.wallet.ui.fragment.template_library_fragment.dark;

import org.recrypt.wallet.model.ContractTemplate;
import org.recrypt.wallet.ui.fragment.template_library_fragment.TemplateLibraryFragment;

import java.util.List;

public class TemplateLibraryFragmentDark extends TemplateLibraryFragment {

    @Override
    protected int getLayout() {
        return org.recrypt.wallet.R.layout.fragment_template_library;
    }

    @Override
    public void setUpTemplateList(List<ContractTemplate> contractTemplateList) {
        initializeRecyclerView(contractTemplateList, org.recrypt.wallet.R.layout.item_template);
    }
}
