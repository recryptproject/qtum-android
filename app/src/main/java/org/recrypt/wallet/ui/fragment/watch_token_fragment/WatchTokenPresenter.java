package org.recrypt.wallet.ui.fragment.watch_token_fragment;

import org.recrypt.wallet.model.ContractTemplate;
import org.recrypt.wallet.ui.base.base_fragment.BaseFragmentPresenter;

public interface WatchTokenPresenter extends BaseFragmentPresenter {

    void onOkClick(String name, String address);

    void onContractAddressEntered(String contractAddress);

}
