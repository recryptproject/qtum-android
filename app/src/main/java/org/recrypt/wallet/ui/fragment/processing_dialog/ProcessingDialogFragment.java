package org.recrypt.wallet.ui.fragment.processing_dialog;

import android.support.v4.app.DialogFragment;
import android.widget.RelativeLayout;

import butterknife.BindView;

public abstract class ProcessingDialogFragment extends DialogFragment {
    @BindView(org.recrypt.wallet.R.id.root_layout)
    protected
    RelativeLayout mRootLayout;
}
