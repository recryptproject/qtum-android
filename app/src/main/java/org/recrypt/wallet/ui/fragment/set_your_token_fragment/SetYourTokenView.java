package org.recrypt.wallet.ui.fragment.set_your_token_fragment;

import org.recrypt.wallet.model.contract.ContractMethodParameter;
import org.recrypt.wallet.ui.base.base_fragment.BaseFragmentView;

import java.util.List;

public interface SetYourTokenView extends BaseFragmentView {
    void onContractConstructorPrepared(List<ContractMethodParameter> params);
}
