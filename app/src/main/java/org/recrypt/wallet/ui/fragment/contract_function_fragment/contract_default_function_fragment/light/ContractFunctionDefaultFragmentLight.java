package org.recrypt.wallet.ui.fragment.contract_function_fragment.contract_default_function_fragment.light;

import org.recrypt.wallet.model.AddressWithBalance;
import org.recrypt.wallet.model.contract.ContractMethodParameter;
import org.recrypt.wallet.ui.fragment.contract_function_fragment.ParameterAdapter;
import org.recrypt.wallet.ui.fragment.contract_function_fragment.contract_default_function_fragment.AddressesWithBalanceSpinnerAdapter;
import org.recrypt.wallet.ui.fragment.contract_function_fragment.contract_default_function_fragment.ContractFunctionDefaultFragment;

import java.util.List;

public class ContractFunctionDefaultFragmentLight extends ContractFunctionDefaultFragment {

    @Override
    protected int getLayout() {
        return org.recrypt.wallet.R.layout.fragment_function_detail_light;
    }

    @Override
    public void setUpParameterList(List<ContractMethodParameter> contractMethodParameterList) {
        mParameterAdapter = new ParameterAdapter(contractMethodParameterList, org.recrypt.wallet.R.layout.lyt_constructor_input_light);
        mParameterList.setAdapter(mParameterAdapter);
    }

    @Override
    public void updateAddressWithBalanceSpinner(List<AddressWithBalance> addressWithBalances) {
        AddressesWithBalanceSpinnerAdapter adapter = new AddressesWithBalanceSpinnerAdapterLight(getContext(), addressWithBalances);
        mSpinner.setAdapter(adapter);
    }
}
