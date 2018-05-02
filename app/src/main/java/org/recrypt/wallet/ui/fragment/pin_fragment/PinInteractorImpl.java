package org.recrypt.wallet.ui.fragment.pin_fragment;

import android.content.Context;

import org.recrypt.wallet.R;
import org.recrypt.wallet.utils.CryptoUtils;
import org.recrypt.wallet.utils.CryptoUtilsCompat;
import org.recrypt.wallet.utils.crypto.AESUtil;
import org.recrypt.wallet.utils.crypto.KeyStoreHelper;
import org.recrypt.wallet.datastorage.KeyStorage;
import org.recrypt.wallet.datastorage.RecryptSharedPreference;

import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import javax.crypto.Cipher;

import rx.Observable;

class PinInteractorImpl implements PinInteractor {

    private Context mContext;
    private final String RECRYPT_PIN_ALIAS = "recrypt_alias";

    PinInteractorImpl(Context context) {
        mContext = context;
        try {
            KeyStoreHelper.createKeys(mContext, RECRYPT_PIN_ALIAS);
        } catch (NoSuchProviderException | NoSuchAlgorithmException | InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getPassword() {
        String sixDigitPassword = getSixDigitPassword();
        if (!getSixDigitPassword().isEmpty()) {
            return sixDigitPassword;
        } else {
            return getFourDigitPassword();
        }
    }

    @Override
    public void savePassword(String password) {
        saveSixDigitPassword(password);
    }


    private String getFourDigitPassword() {
        String encryptedPinHash = RecryptSharedPreference.getInstance().getPassword(mContext);
        return KeyStoreHelper.decrypt(RECRYPT_PIN_ALIAS, encryptedPinHash);
    }

    private void saveFourDigitPassword(String password) {
        String encryptedPinHash = KeyStoreHelper.encrypt(RECRYPT_PIN_ALIAS, password);
        RecryptSharedPreference.getInstance().savePassword(mContext, encryptedPinHash);
    }

    @Override
    public String getSixDigitPassword() {
        String encryptedPinHash = RecryptSharedPreference.getInstance().getSixDigitPassword(mContext);
        if (encryptedPinHash.isEmpty()) {
            return encryptedPinHash;
        }
        return KeyStoreHelper.decrypt(RECRYPT_PIN_ALIAS, encryptedPinHash);
    }

    @Override
    public Integer getFailedAttemptsCount() {
        return RecryptSharedPreference.getInstance().getFailedAttemptsCount(mContext);
    }

    @Override
    public Long getBanTime() {
        return RecryptSharedPreference.getInstance().getBanTime(mContext);
    }

    @Override
    public void setFailedAttemptsCount(int failedAttemptsCount) {
        RecryptSharedPreference.getInstance().setFailedAttemptsCount(mContext, failedAttemptsCount);
    }

    @Override
    public void setBanTime(long banTime) {
        RecryptSharedPreference.getInstance().setBanTime(mContext, banTime);
    }

    @Override
    public void saveSixDigitPassword(String password) {
        String encryptedPinHash = KeyStoreHelper.encrypt(RECRYPT_PIN_ALIAS, password);
        RecryptSharedPreference.getInstance().saveSixDigitPassword(mContext, encryptedPinHash);
    }

    @Override
    public void savePassphraseSaltWithPin(String pin, String passphrase) {
        byte[] saltPassphrase = AESUtil.encryptToBytes(pin, passphrase);
        String encryptedSaltPassphrase = KeyStoreHelper.encryptBytes(RECRYPT_PIN_ALIAS, saltPassphrase);
        RecryptSharedPreference.getInstance().saveSeed(mContext, encryptedSaltPassphrase);
    }

    @Override
    public byte[] getSaltPassphrase() {
        String encryptedSaltPassphrase = RecryptSharedPreference.getInstance().getSeed(mContext);
        return KeyStoreHelper.decryptToBytes(RECRYPT_PIN_ALIAS, encryptedSaltPassphrase);
    }

    @Override
    public String getTouchIdPassword() {
        return RecryptSharedPreference.getInstance().getTouchIdPassword(mContext);
    }

    @Override
    public void saveTouchIdPassword(String password) {
        RecryptSharedPreference.getInstance().saveTouchIdPassword(mContext, password);
    }

    @Override
    public String getRandomSeed(){
        return KeyStorage.getInstance().getRandomSeed();
    }

    @Override
    public void setKeyGeneratedInstance(boolean isKeyGenerated) {
        RecryptSharedPreference.getInstance().setKeyGeneratedInstance(mContext, isKeyGenerated);
    }

    @Override
    public String decode(String encoded, Cipher cipher) {
        return CryptoUtils.decode(encoded, cipher);
    }

    @Override
    public Observable<String> encodeInBackground(String pin) {
        return CryptoUtils.encodeInBackground(pin);
    }

    @Override
    public String generateSHA256String(String pin) {
        return CryptoUtilsCompat.generateSHA256String(pin);
    }

    @Override
    public String getUnSaltPassphrase(String oldPin) {
        byte[] oldSaltPassphrase = getSaltPassphrase();
        return AESUtil.decryptBytes(oldPin, oldSaltPassphrase);
    }

    @Override
    public String getBanPinString(int min) {
        return mContext.getString(R.string.sorry_please_try_again_in) + " " + min + " " + mContext.getString(R.string.minutes);
    }

    @Override
    public Observable<String> loadWallet(String code) {
        return KeyStorage.getInstance().createWallet(KeyStoreHelper.getSeed(mContext, code));
    }
}