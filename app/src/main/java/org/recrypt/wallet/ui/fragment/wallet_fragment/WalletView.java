package org.recrypt.wallet.ui.fragment.wallet_fragment;

import org.recrypt.wallet.model.gson.history.History;
import org.recrypt.wallet.ui.base.base_fragment.BaseFragmentView;

import java.util.List;

public interface WalletView extends BaseFragmentView {
    void updateHistory(List<History> historyList);

    void setAdapterNull();

    void updateBalance(String balance, String unconfirmedBalance);

    void updatePubKey(String pubKey);

    void startRefreshAnimation();

    void stopRefreshRecyclerAnimation();

    void addHistory(int positionStart, int itemCount, List<History> historyList);

    void loadNewHistory();

    void notifyNewHistory();

    void notifyConfirmHistory(int notifyPosition);

    void openTransactionsFragment(int position);
}
