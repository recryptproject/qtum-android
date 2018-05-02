package org.recrypt.wallet.ui.fragment.currency_fragment;

import android.content.Context;

import org.recrypt.wallet.R;
import org.recrypt.wallet.model.Currency;
import org.recrypt.wallet.model.CurrencyToken;
import org.recrypt.wallet.model.contract.ContractCreationStatus;
import org.recrypt.wallet.model.contract.Token;
import org.recrypt.wallet.datastorage.TinyDB;

import java.util.ArrayList;
import java.util.List;

class CurrencyInteractorImpl implements CurrencyInteractor {

    private Context mContext;

    CurrencyInteractorImpl(Context context) {
        mContext = context;
    }

    @Override
    public List<Currency> getCurrencies() {
        List<Currency> currencies = new ArrayList<>();
        List<Token> tokens = (new TinyDB(mContext)).getTokenList();
        Currency currency = new Currency("Recrypt " + mContext.getString(R.string.default_currency));
        currencies.add(currency);
        for (Token token : tokens) {
            if (token.getCreationStatus().equals(ContractCreationStatus.Created) && token.isSubscribe()) {
                currency = new CurrencyToken(token.getContractName(), token);
                currencies.add(currency);
            }
        }
        return currencies;
    }
}
