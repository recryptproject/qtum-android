package org.recrypt.wallet.ui.fragment.subscribe_tokens_fragment;

import org.recrypt.wallet.model.contract.Token;
import org.recrypt.wallet.ui.base.base_fragment.BaseFragmentPresenter;

import java.util.List;

public interface AddressesListTokenPresenter extends BaseFragmentPresenter {
    void saveTokens(List<Token> tokens);
}