package org.recrypt.wallet.ui.fragment.watch_token_fragment.dark;

import org.recrypt.wallet.R;
import org.recrypt.wallet.model.ContractTemplate;
import org.recrypt.wallet.ui.fragment.watch_contract_fragment.OnTemplateClickListener;
import org.recrypt.wallet.ui.fragment.watch_contract_fragment.TemplatesAdapter;
import org.recrypt.wallet.ui.fragment.watch_contract_fragment.WatchContractFragment;
import org.recrypt.wallet.ui.fragment.watch_token_fragment.WatchTokenFragment;
import org.recrypt.wallet.utils.FontManager;

import java.util.List;

public class WatchTokenFragmentDark extends WatchTokenFragment {

    @Override
    protected int getLayout() {
        return R.layout.fragment_watch_token;
    }

    @Override
    public void initializeViews() {
        super.initializeViews();
        mEditTextContractName.setTypeface(FontManager.getInstance().getFont(getResources().getString(R.string.simplonMonoMedium)));
        mEditTextContractAddress.setTypeface(FontManager.getInstance().getFont(getResources().getString(R.string.simplonMonoMedium)));
    }

}
