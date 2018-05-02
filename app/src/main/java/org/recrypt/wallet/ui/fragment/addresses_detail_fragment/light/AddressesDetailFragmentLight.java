package org.recrypt.wallet.ui.fragment.addresses_detail_fragment.light;

import org.recrypt.wallet.R;
import org.recrypt.wallet.model.gson.history.TransactionInfo;
import org.recrypt.wallet.model.gson.history.Vin;
import org.recrypt.wallet.model.gson.history.Vout;
import org.recrypt.wallet.ui.fragment.addresses_detail_fragment.AddressesDetailFragment;

import java.util.List;

public class AddressesDetailFragmentLight extends AddressesDetailFragment {

    @Override
    protected int getLayout() {
        return R.layout.fragment_addresses_detail_light;
    }

    @Override
    public void setUpRecyclerView(List<Vin> transactionFrom, List<Vout> transactionTo) {
        mAddressesDetailAdapterTo = new AddressesDetailAdapterLight<>(transactionTo);
        mAddressesDetailAdapterFrom = new AddressesDetailAdapterLight<>(transactionFrom);
        mRecyclerViewFrom.setAdapter(mAddressesDetailAdapterFrom);
        mRecyclerViewTo.setAdapter(mAddressesDetailAdapterTo);
    }
}
