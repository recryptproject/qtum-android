package org.recrypt.wallet.ui.fragment.about_fragment;

import org.recrypt.wallet.model.Version;
import org.recrypt.wallet.ui.base.base_fragment.BaseFragmentView;

public interface AboutView extends BaseFragmentView {
    void updateVersion(Version version);
}
