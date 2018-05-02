package org.recrypt.wallet.ui.fragment.subscribe_tokens_fragment;

import android.content.Context;

import org.recrypt.wallet.model.contract.Token;
import org.recrypt.wallet.datastorage.TinyDB;

import java.util.List;

public class SubscribeTokensInteractorImpl implements SubscribeTokensInteractor {

    private Context mContext;

    public SubscribeTokensInteractorImpl(Context context) {
        mContext = context;
    }

    @Override
    public List<Token> getTokenList() {
        return (new TinyDB(mContext)).getTokenList();
    }

    @Override
    public void saveTokenList(List<Token> tokenList) {
        (new TinyDB(mContext)).putTokenList(tokenList);
    }
}
