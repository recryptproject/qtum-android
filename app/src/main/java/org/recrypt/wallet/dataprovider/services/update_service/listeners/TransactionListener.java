package org.recrypt.wallet.dataprovider.services.update_service.listeners;

import org.recrypt.wallet.model.gson.history.History;

public interface TransactionListener {
    void onNewHistory(History history);

    boolean getVisibility();
}
