package org.recrypt.wallet.ui.fragment.token_cash_management_fragment;

import android.os.Handler;

import org.recrypt.wallet.dataprovider.services.update_service.UpdateService;
import org.recrypt.wallet.model.DeterministicKeyWithTokenBalance;
import org.recrypt.wallet.ui.base.base_fragment.BaseFragmentView;

import java.util.List;

public interface AddressesListTokenView extends BaseFragmentView {
    void updateAddressList(List<DeterministicKeyWithTokenBalance> deterministicKeyWithBalance, String currency);

    UpdateService getSocketInstance();

    Handler getHandler();

    void hideTransferDialog();

    void goToSendFragment(DeterministicKeyWithTokenBalance keyWithTokenBalanceFrom, DeterministicKeyWithTokenBalance keyWithBalanceTo, String amountString, String contractAddress);
}
