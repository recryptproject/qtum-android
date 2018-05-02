package org.recrypt.wallet.ui.fragment.watch_token_fragment.light;

import org.recrypt.wallet.model.ContractTemplate;
import org.recrypt.wallet.ui.fragment.watch_contract_fragment.OnTemplateClickListener;
import org.recrypt.wallet.ui.fragment.watch_contract_fragment.TemplatesAdapter;
import org.recrypt.wallet.ui.fragment.watch_contract_fragment.WatchContractFragment;
import org.recrypt.wallet.ui.fragment.watch_token_fragment.WatchTokenFragment;
import org.recrypt.wallet.utils.FontManager;

import java.util.List;

public class WatchTokenFragmentLight extends WatchTokenFragment {

    @Override
    protected int getLayout() {
        return org.recrypt.wallet.R.layout.fragment_watch_token_light;
    }

    @Override
    public void initializeViews() {
        super.initializeViews();
        mEditTextContractName.setTypeface(FontManager.getInstance().getFont(getResources().getString(org.recrypt.wallet.R.string.proximaNovaSemibold)));
        mEditTextContractAddress.setTypeface(FontManager.getInstance().getFont(getResources().getString(org.recrypt.wallet.R.string.proximaNovaSemibold)));
    }

}
