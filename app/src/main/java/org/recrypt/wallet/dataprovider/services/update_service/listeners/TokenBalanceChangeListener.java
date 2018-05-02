package org.recrypt.wallet.dataprovider.services.update_service.listeners;

import org.recrypt.wallet.model.gson.token_balance.TokenBalance;

public interface TokenBalanceChangeListener {
    void onBalanceChange(TokenBalance tokenBalance);
}
