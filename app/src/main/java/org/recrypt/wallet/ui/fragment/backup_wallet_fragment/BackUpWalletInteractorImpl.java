package org.recrypt.wallet.ui.fragment.backup_wallet_fragment;

import android.content.Context;

import org.recrypt.wallet.datastorage.RecryptSharedPreference;
import org.recrypt.wallet.utils.crypto.AESUtil;
import org.recrypt.wallet.utils.crypto.KeyStoreHelper;

class BackUpWalletInteractorImpl implements BackUpWalletInteractor {

    private Context mContext;

    private final String RECRYPT_PIN_ALIAS = "recrypt_alias";

    BackUpWalletInteractorImpl(Context context) {
        mContext = context;
    }

    @Override
    public String getPassphrase(String pin) {
        String cryptoSaltPassphrase = RecryptSharedPreference.getInstance().getSeed(mContext);
        byte[] saltPassphrase = KeyStoreHelper.decryptToBytes(RECRYPT_PIN_ALIAS, cryptoSaltPassphrase);
        return AESUtil.decryptBytes(pin, saltPassphrase);
    }
}
