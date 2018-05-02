package org.recrypt.wallet.ui.fragment.watch_contract_fragment;

import org.recrypt.wallet.model.ContractTemplate;
import org.recrypt.wallet.model.contract.Contract;

import java.util.List;

public interface WatchContractInteractor {
    List<ContractTemplate> getContractTemplates();

    int compareDates(String date, String date1);

    String readAbiContract(String uuid);

    boolean isValidContractAddress(String address);

    List<Contract> getContracts();

    void handleContractWithoutToken(String name, String address, String ABIInterface);
}
