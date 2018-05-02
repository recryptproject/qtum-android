package org.recrypt.wallet.ui.fragment.contract_confirm_fragment;

import org.recrypt.wallet.RecryptApplication;
import org.recrypt.wallet.ui.base.base_fragment.BaseFragmentView;

public interface ContractConfirmView extends BaseFragmentView {

    void makeToast(String s);

    RecryptApplication getApplication();

    String getContractName();

    void updateFee(double minFee, double maxFee);

    void updateGasPrice(int minGasPrice, int maxGasPrice);

    void updateGasLimit(int minGasLimit, int maxGasLimit);

    void closeFragments();
}
