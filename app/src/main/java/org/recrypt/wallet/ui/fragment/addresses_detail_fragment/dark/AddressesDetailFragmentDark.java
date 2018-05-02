package org.recrypt.wallet.ui.fragment.addresses_detail_fragment.dark;

import org.recrypt.wallet.R;
import org.recrypt.wallet.model.gson.history.TransactionInfo;
import org.recrypt.wallet.model.gson.history.Vin;
import org.recrypt.wallet.model.gson.history.Vout;
import org.recrypt.wallet.ui.fragment.addresses_detail_fragment.AddressesDetailFragment;

import java.util.List;

public class AddressesDetailFragmentDark extends AddressesDetailFragment {


    @Override
    protected int getLayout() {
        return R.layout.fragment_addresses_detail;
    }


    @Override
    public void setUpRecyclerView(List<Vin> transactionFrom, List<Vout> transactionTo) {
        mAddressesDetailAdapterTo = new AddressesDetailAdapterDark<>(transactionTo);
        mAddressesDetailAdapterFrom = new AddressesDetailAdapterDark<>(transactionFrom);
        mRecyclerViewFrom.setAdapter(mAddressesDetailAdapterFrom);
        mRecyclerViewTo.setAdapter(mAddressesDetailAdapterTo);
    }
}
