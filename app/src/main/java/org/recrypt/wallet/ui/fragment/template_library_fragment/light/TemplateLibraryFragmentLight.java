package org.recrypt.wallet.ui.fragment.template_library_fragment.light;

import org.recrypt.wallet.R;
import org.recrypt.wallet.model.ContractTemplate;
import org.recrypt.wallet.ui.fragment.template_library_fragment.TemplateLibraryFragment;

import java.util.List;

public class TemplateLibraryFragmentLight extends TemplateLibraryFragment {

    @Override
    protected int getLayout() {
        return R.layout.fragment_template_library_light;
    }

    @Override
    public void setUpTemplateList(List<ContractTemplate> contractTemplateList) {
        initializeRecyclerView(contractTemplateList, R.layout.item_template_light);
    }
}
