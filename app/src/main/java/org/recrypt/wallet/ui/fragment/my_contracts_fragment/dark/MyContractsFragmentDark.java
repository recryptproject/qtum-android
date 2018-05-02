package org.recrypt.wallet.ui.fragment.my_contracts_fragment.dark;

import org.recrypt.wallet.model.contract.Contract;
import org.recrypt.wallet.ui.fragment.my_contracts_fragment.ContractItemListener;
import org.recrypt.wallet.ui.fragment.my_contracts_fragment.MyContractsFragment;

import java.util.List;

public class MyContractsFragmentDark extends MyContractsFragment {

    @Override
    protected int getLayout() {
        return org.recrypt.wallet.R.layout.fragment_my_contracts;
    }


    @Override
    public void setUpRecyclerView(List<Contract> contractList, ContractItemListener contractItemListener) {
        mContractAdapter = new ContractAdapter(contractList, org.recrypt.wallet.R.layout.item_contract_list, contractItemListener);
        mRecyclerView.setAdapter(mContractAdapter);
    }
}
