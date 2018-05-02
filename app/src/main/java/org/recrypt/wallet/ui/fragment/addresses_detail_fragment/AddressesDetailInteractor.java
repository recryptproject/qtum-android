package org.recrypt.wallet.ui.fragment.addresses_detail_fragment;


import org.recrypt.wallet.model.gson.history.History;


public interface AddressesDetailInteractor {
    History getHistory(int position);
}
