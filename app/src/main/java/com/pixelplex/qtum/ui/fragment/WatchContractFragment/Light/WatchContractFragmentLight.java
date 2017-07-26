package com.pixelplex.qtum.ui.fragment.WatchContractFragment.Light;

import com.pixelplex.qtum.R;
import com.pixelplex.qtum.model.ContractTemplate;
import com.pixelplex.qtum.ui.fragment.WatchContractFragment.OnTemplateClickListener;
import com.pixelplex.qtum.ui.fragment.WatchContractFragment.TemplatesAdapter;
import com.pixelplex.qtum.ui.fragment.WatchContractFragment.WatchContractFragment;

import java.util.List;

/**
 * Created by kirillvolkov on 25.07.17.
 */

public class WatchContractFragmentLight extends WatchContractFragment {

    @Override
    protected int getLayout() {
        return R.layout.fragment_watch_contract_light;
    }

    @Override
    public void setUpTemplatesList(List<ContractTemplate> contractTemplateList, OnTemplateClickListener listener) {
        mRecyclerViewTemplates.setAdapter(new TemplatesAdapter(contractTemplateList, listener, R.layout.item_template_chips_light));
    }

}