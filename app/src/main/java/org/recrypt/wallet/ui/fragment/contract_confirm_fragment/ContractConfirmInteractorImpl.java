package org.recrypt.wallet.ui.fragment.contract_confirm_fragment;

import android.content.Context;

import org.bitcoinj.script.Script;
import org.recrypt.wallet.dataprovider.rest_api.recrypt.RecryptService;
import org.recrypt.wallet.datastorage.KeyStorage;
import org.recrypt.wallet.datastorage.RecryptSettingSharedPreference;
import org.recrypt.wallet.datastorage.RecryptSharedPreference;
import org.recrypt.wallet.datastorage.TinyDB;
import org.recrypt.wallet.model.ContractTemplate;
import org.recrypt.wallet.model.TransactionHashWithSender;
import org.recrypt.wallet.model.contract.Contract;
import org.recrypt.wallet.model.contract.ContractCreationStatus;
import org.recrypt.wallet.model.contract.ContractMethodParameter;
import org.recrypt.wallet.model.contract.Token;
import org.recrypt.wallet.model.gson.SendRawTransactionRequest;
import org.recrypt.wallet.model.gson.SendRawTransactionResponse;
import org.recrypt.wallet.model.gson.UnspentOutput;
import org.recrypt.wallet.utils.ContractBuilder;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import rx.Observable;

class ContractConfirmInteractorImpl implements ContractConfirmInteractor {

    Context mContext;

    ContractConfirmInteractorImpl(Context context) {
        mContext = context;
    }

    @Override
    public Observable<String> createAbiConstructParams(List<ContractMethodParameter> contractMethodParameterList, String uiid) {
        ContractBuilder contractBuilder = new ContractBuilder();
        return contractBuilder.createAbiConstructParams(contractMethodParameterList, uiid, mContext);
    }

    @Override
    public Observable<List<UnspentOutput>> getUnspentOutputsForSeveralAddresses() {
        return RecryptService.newInstance().getUnspentOutputsForSeveralAddresses(KeyStorage.getInstance().getAddresses());
    }

    @Override
    public Observable<SendRawTransactionResponse> sendRawTransaction(SendRawTransactionRequest sendRawTransactionRequest) {
        return RecryptService.newInstance().sendRawTransaction(sendRawTransactionRequest);
    }

    @Override
    public void saveContract(String txid, String contractTemplateUiid, String contractName, String senderAddress) {
        TinyDB tinyDB = new TinyDB(mContext);
        ArrayList<String> unconfirmedTokenTxHashList = tinyDB.getUnconfirmedContractTxHasList();
        unconfirmedTokenTxHashList.add(txid);
        tinyDB.putUnconfirmedContractTxHashList(unconfirmedTokenTxHashList);
        for (ContractTemplate contractTemplate : tinyDB.getContractTemplateList()) {
            if (contractTemplate.getUuid().equals(contractTemplateUiid)) {
                if (contractTemplate.getContractType().equals("token")) {
                    saveToken(tinyDB, txid, contractTemplateUiid, contractName, senderAddress);
                } else {
                    saveContract(tinyDB, txid, contractTemplateUiid, contractName, senderAddress);
                    if (contractTemplate.getContractType().equals("crowdsale")) {
                        saveToken(tinyDB, txid, contractTemplateUiid, contractName, senderAddress);
                    }
                }
            }
        }
    }

    private void saveToken(TinyDB tinyDB, String txid, String contractTemplateUiid, String contractName, String senderAddress) {
        Token token = new Token(ContractBuilder.generateContractAddress(txid), contractTemplateUiid, ContractCreationStatus.Unconfirmed, null, senderAddress, contractName);
        List<Token> tokenList = tinyDB.getTokenList();
        tokenList.add(token);
        tinyDB.putTokenList(tokenList);
    }

    private void saveContract(TinyDB tinyDB, String txid, String contractTemplateUiid, String contractName, String senderAddress) {
        Contract contract = new Contract(ContractBuilder.generateContractAddress(txid), contractTemplateUiid, ContractCreationStatus.Unconfirmed, null, senderAddress, contractName);
        List<Contract> contractList = tinyDB.getContractListWithoutToken();
        contractList.add(contract);
        tinyDB.putContractListWithoutToken(contractList);
    }

    @Override
    public TransactionHashWithSender createTransactionHash(String abiParams, List<UnspentOutput> unspentOutputs, int gasLimit, int gasPrice, String fee) {
        ContractBuilder contractBuilder = new ContractBuilder();
        Script script = contractBuilder.createConstructScript(abiParams, gasLimit, gasPrice);
        return contractBuilder.createTransactionHashForCreateContract(script, unspentOutputs, gasLimit, gasPrice, getFeePerKb(), fee, mContext);
    }

    @Override
    public BigDecimal getFeePerKb() {
        RecryptSettingSharedPreference recryptSettingSharedPreference = new RecryptSettingSharedPreference();
        return new BigDecimal(recryptSettingSharedPreference.getFeePerKb(mContext));
    }

    @Override
    public int getMinGasPrice() {
        return RecryptSharedPreference.getInstance().getMinGasPrice(mContext);
    }
}
