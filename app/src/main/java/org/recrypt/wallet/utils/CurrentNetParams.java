package org.recrypt.wallet.utils;

import org.bitcoinj.core.NetworkParameters;
import org.bitcoinj.params.RecryptMainNetParams;
import org.bitcoinj.params.RecryptTestNetParams;
import org.recrypt.wallet.BuildConfig;

public class CurrentNetParams {

    public  CurrentNetParams(){}

    public static NetworkParameters getNetParams(){
        return BuildConfig.USE_MAIN_NET? RecryptMainNetParams.get() : RecryptTestNetParams.get();
    }

    public static String getUrl(){
        return "https://testnet-walletapi.recrypt.org"; //BuildConfig.API_URL;
    }
}
