package org.recrypt.wallet.ui.fragment.other_tokens;

import org.recrypt.wallet.model.contract.Token;
import org.recrypt.wallet.ui.base.base_fragment.BaseFragmentView;

import java.util.List;

public interface OtherTokensView extends BaseFragmentView {
    void setTokensData(List<Token> tokensData);

    void updateTokensData(List<Token> tokensData);
}
