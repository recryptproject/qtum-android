package org.recrypt.wallet.ui.fragment.wallet_fragment;

import org.recrypt.wallet.model.gson.history.History;
import org.recrypt.wallet.ui.base.base_fragment.BaseFragmentPresenter;

import java.util.List;

public interface WalletPresenter extends BaseFragmentPresenter {

    void onRefresh();

    void openTransactionFragment(int position);

    void onLastItem(int currentItemCount);

    void onNetworkStateChanged(boolean networkConnectedFlag);

    void onNewHistory(History history);

    boolean getVisibility();

    void updateVisibility(boolean value);

}
