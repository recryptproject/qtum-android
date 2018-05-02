package org.recrypt.wallet.ui.fragment.currency_fragment;

import org.recrypt.wallet.model.Currency;
import org.recrypt.wallet.ui.base.base_fragment.BaseFragmentView;

import java.util.List;

public interface CurrencyView extends BaseFragmentView {
    void setCurrencyList(List<Currency> currencyList);
}
