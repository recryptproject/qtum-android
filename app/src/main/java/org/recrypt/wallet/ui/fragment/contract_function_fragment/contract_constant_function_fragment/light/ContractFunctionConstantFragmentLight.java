package org.recrypt.wallet.ui.fragment.contract_function_fragment.contract_constant_function_fragment.light;

import org.recrypt.wallet.model.contract.ContractMethodParameter;
import org.recrypt.wallet.ui.fragment.contract_function_fragment.ParameterAdapter;
import org.recrypt.wallet.ui.fragment.contract_function_fragment.contract_constant_function_fragment.ContractFunctionConstantFragment;

import java.util.List;

public class ContractFunctionConstantFragmentLight extends ContractFunctionConstantFragment {

    @Override
    protected int getLayout() {
        return org.recrypt.wallet.R.layout.fragment_function_constant_detail_light;
    }

    @Override
    public void setUpParameterList(List<ContractMethodParameter> contractMethodParameterList) {
        mParameterAdapter = new ParameterAdapter(contractMethodParameterList, org.recrypt.wallet.R.layout.lyt_constructor_input_light);
        mParameterList.setAdapter(mParameterAdapter);
    }
}
