package org.recrypt.wallet.ui.fragment.profile_fragment;

import org.recrypt.wallet.ui.base.base_fragment.BaseFragmentView;

public interface ProfileView extends BaseFragmentView {
    void startDialogFragmentForResult();

    void resetText();

    boolean checkAvailabilityTouchId();
}
