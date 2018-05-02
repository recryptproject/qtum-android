package org.recrypt.wallet.ui.fragment.other_tokens.light;

import org.recrypt.wallet.model.contract.Token;
import org.recrypt.wallet.ui.base.base_fragment.BaseFragment;
import org.recrypt.wallet.ui.fragment.other_tokens.OtherTokensFragment;
import org.recrypt.wallet.ui.fragment.token_fragment.TokenFragment;

import java.util.List;

public class OtherTokensFragmentLight extends OtherTokensFragment {

    @Override
    protected int getLayout() {
        return org.recrypt.wallet.R.layout.lyt_other_tokens_light;
    }

    @Override
    public void setTokensData(List<Token> tokensData) {
        tokensList.setAdapter(new TokensAdapterLight(tokensData, this, this));
    }

    @Override
    public void onTokenClick(int adapterPosition) {
        if (tokensList.getAdapter() != null) {
            BaseFragment tokenFragment = TokenFragment.newInstance(getContext(), ((TokensAdapterLight) tokensList.getAdapter()).get(adapterPosition));
            openFragment(tokenFragment);
        }
    }
}
