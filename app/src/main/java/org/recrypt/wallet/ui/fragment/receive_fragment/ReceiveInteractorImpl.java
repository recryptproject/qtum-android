package org.recrypt.wallet.ui.fragment.receive_fragment;

import android.content.Context;

import org.recrypt.wallet.datastorage.KeyStorage;

import java.math.BigDecimal;

class ReceiveInteractorImpl implements ReceiveInteractor {
    private Context mContext;

    ReceiveInteractorImpl(Context context) {
        mContext = context;
    }

    @Override
    public String getCurrentReceiveAddress() {
        return KeyStorage.getInstance().getCurrentAddress();
    }

    @Override
    public String formatReceiveAddress(String addr) {
        return String.format("recrypt:%s?", addr);
    }

    @Override
    public String formatAmount(String amount) {
        return String.format("amount=%s&", amount);
    }

    @Override
    public String formatTokenAddress(String addr) {
        return String.format("&tokenAddress=%s", addr);
    }

    @Override
    public String formatBalance(String balanceString) {
        return String.format("%S RECRYPT", balanceString);
    }

    @Override
    public String formatUnconfirmedBalance(BigDecimal unconfirmedBalance) {
        return String.format("%S RECRYPT", String.valueOf(unconfirmedBalance.floatValue()));
    }
}