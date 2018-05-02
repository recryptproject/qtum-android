package org.recrypt.wallet.ui.fragment.contract_confirm_fragment;

import org.recrypt.wallet.model.TransactionHashWithSender;
import org.recrypt.wallet.model.contract.ContractMethodParameter;
import org.recrypt.wallet.model.gson.SendRawTransactionRequest;
import org.recrypt.wallet.model.gson.SendRawTransactionResponse;
import org.recrypt.wallet.model.gson.UnspentOutput;

import java.math.BigDecimal;
import java.util.List;

import rx.Observable;

public interface ContractConfirmInteractor {
    Observable<String> createAbiConstructParams(List<ContractMethodParameter> contractMethodParameterList, String uiid);

    Observable<List<UnspentOutput>> getUnspentOutputsForSeveralAddresses();

    Observable<SendRawTransactionResponse> sendRawTransaction(SendRawTransactionRequest sendRawTransactionRequest);

    void saveContract(String txid, String contractTemplateUiid, String contractName, String senderAddress);

    TransactionHashWithSender createTransactionHash(String abiParams, List<UnspentOutput> unspentOutputs, int gasLimit, int gasPrice, String fee);

    BigDecimal getFeePerKb();

    int getMinGasPrice();
}
