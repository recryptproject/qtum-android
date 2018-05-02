package org.recrypt.wallet.ui.fragment.transaction_fragment;

import org.recrypt.wallet.ui.base.base_fragment.BaseFragmentPresenter;

interface TransactionPresenter extends BaseFragmentPresenter {
    void openTransactionView(int position);
}
