package org.recrypt.wallet.ui.fragment.templates_fragment.dark;

import org.recrypt.wallet.model.ContractTemplate;
import org.recrypt.wallet.ui.fragment.templates_fragment.TemplatesFragment;

import java.util.List;

public class TemplatesFragmentDark extends TemplatesFragment {

    @Override
    protected int getLayout() {
        return org.recrypt.wallet.R.layout.fragment_templates;
    }

    @Override
    public void setUpTemplateList(List<ContractTemplate> contractTemplateList) {
        initializeRecyclerView(contractTemplateList, org.recrypt.wallet.R.layout.item_template);
    }
}
