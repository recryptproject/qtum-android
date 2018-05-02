package org.recrypt.wallet.ui.fragment.subscribe_tokens_fragment;

import org.recrypt.wallet.model.contract.Token;
import org.recrypt.wallet.ui.base.base_fragment.BaseFragmentView;

import java.util.List;

public interface SubscribeTokensView extends BaseFragmentView {
    void setTokenList(List<Token> tokenList);

    List<Token> getTokenList();

    void setPlaceHolder();
}
