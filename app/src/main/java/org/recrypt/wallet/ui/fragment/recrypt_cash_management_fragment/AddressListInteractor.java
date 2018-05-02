package org.recrypt.wallet.ui.fragment.recrypt_cash_management_fragment;

import org.recrypt.wallet.model.gson.UnspentOutput;

import java.util.List;

import rx.Observable;

public interface AddressListInteractor {
    List<String> getAddresses();

    Observable<List<UnspentOutput>> getUnspentOutputs(List<String> addresses);
}
