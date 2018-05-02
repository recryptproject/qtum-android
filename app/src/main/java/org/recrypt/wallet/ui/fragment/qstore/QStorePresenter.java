package org.recrypt.wallet.ui.fragment.qstore;

import org.recrypt.wallet.ui.base.base_fragment.BaseFragmentPresenter;

public interface QStorePresenter extends BaseFragmentPresenter {
    void searchItems(String seacrhBarText, boolean checked);
}
