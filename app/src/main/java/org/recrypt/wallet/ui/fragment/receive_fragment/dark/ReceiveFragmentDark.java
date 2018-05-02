package org.recrypt.wallet.ui.fragment.receive_fragment.dark;

import android.support.v4.content.ContextCompat;

import org.recrypt.wallet.ui.fragment.receive_fragment.ReceiveFragment;

public class ReceiveFragmentDark extends ReceiveFragment {

    @Override
    protected int getLayout() {
        return org.recrypt.wallet.R.layout.fragment_receive;
    }

    @Override
    public void initializeViews() {
        super.initializeViews();
        setQrColors(ContextCompat.getColor(getContext(), org.recrypt.wallet.R.color.colorPrimary), ContextCompat.getColor(getContext(), org.recrypt.wallet.R.color.background));
    }
}
