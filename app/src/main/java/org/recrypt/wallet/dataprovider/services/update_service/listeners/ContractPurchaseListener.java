package org.recrypt.wallet.dataprovider.services.update_service.listeners;

import org.recrypt.wallet.model.gson.qstore.ContractPurchase;

public interface ContractPurchaseListener {
    void onContractPurchased(ContractPurchase purchaseData);
}
