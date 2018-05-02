package org.recrypt.wallet.ui.fragment.currency_fragment.dark;

import org.recrypt.wallet.R;
import org.recrypt.wallet.model.Currency;
import org.recrypt.wallet.ui.fragment.currency_fragment.CurrencyFragment;

import java.util.List;

public class CurrencyFragmentDark extends CurrencyFragment {

    @Override
    protected int getLayout() {
        return R.layout.fragment_currency;
    }

    @Override
    public void setCurrencyList(List<Currency> currencyList) {
        mCurrencyAdapter = new CurrencyAdapter(currencyList, R.layout.lyt_token_list_item);
        mCurrentList = currencyList;
        mRecyclerView.setAdapter(mCurrencyAdapter);
    }
}
