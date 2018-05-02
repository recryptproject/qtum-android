package org.recrypt.wallet.ui.fragment.token_fragment;

import org.recrypt.wallet.model.gson.token_history.TokenHistory;
import org.recrypt.wallet.ui.base.base_fragment.BaseFragmentView;
import org.recrypt.wallet.utils.ContractManagementHelper;

import java.util.List;

import rx.Subscriber;

public interface TokenView extends BaseFragmentView {
    void setBalance(String balance);

    void setTokenAddress(String address);

    void setRecryptAddress(String address);

    void onContractPropertyUpdated(String propName, String propValue);

    void setSenderAddress(String address);

    String getCurrency();

    String getTokenBalance();

    boolean isAbiEmpty(String abi);

    Subscriber<String> getNameValueCallback();

    Subscriber<String> getSymbolValueCallback();

    Subscriber<String> getDecimalsValueCallback();

    Subscriber<String> getTotalSupplyValueCallback();

    void updateHistory(List<TokenHistory> tokenHistories);

    void addHistory(int positionStart, int itemCount, List<TokenHistory> historyList);
}
