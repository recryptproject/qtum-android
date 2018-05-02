package org.recrypt.wallet.ui.fragment.set_your_token_fragment.dark;

import org.recrypt.wallet.R;
import org.recrypt.wallet.model.contract.ContractMethodParameter;
import org.recrypt.wallet.ui.fragment.set_your_token_fragment.SetYourTokenFragment;

import java.util.List;

import butterknife.OnClick;

public class SetYourTokenFragmentDark extends SetYourTokenFragment {

    private final int LAYOUT = R.layout.fragment_set_your_token;

    @OnClick(R.id.cancel)
    public void onCancelClick() {
        getActivity().onBackPressed();
    }

    @Override
    protected int getLayout() {
        return LAYOUT;
    }

    @Override
    public void onContractConstructorPrepared(List<ContractMethodParameter> params) {
        adapter = new ConstructorAdapterDark(params, this);
        constructorList.setAdapter(adapter);
    }
}
