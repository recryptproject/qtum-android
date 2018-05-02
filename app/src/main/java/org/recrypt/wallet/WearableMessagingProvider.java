package org.recrypt.wallet;

import org.recrypt.wallet.model.gson.history.History;

import java.util.List;

/**
 * Created by kirillvolkov on 21.11.2017.
 */

public interface WearableMessagingProvider {
    List<History> getOperations();
    String getBalance();
    String getUnconfirmedBalance();
    String getAddress();
}
