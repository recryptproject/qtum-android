package org.recrypt.wallet.ui.fragment.addresses_detail_fragment;


import org.recrypt.wallet.model.gson.history.Vin;
import org.recrypt.wallet.model.gson.history.Vout;
import org.recrypt.wallet.ui.base.base_fragment.BaseFragmentView;

import java.util.List;

interface AddressesDetailView extends BaseFragmentView{
    void setUpRecyclerView(List<Vin> transactionFrom, List<Vout> transactionTo);
    int getPosition();
}
