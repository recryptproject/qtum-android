package org.recrypt.wallet.ui.fragment.store_contract.dark;

import org.recrypt.wallet.model.gson.qstore.QstoreContract;
import org.recrypt.wallet.ui.fragment.store_contract.StoreContractFragment;
import org.recrypt.wallet.ui.fragment.store_contract.TagRecyclerViewAdapter;
import org.recrypt.wallet.utils.DateCalculator;

import butterknife.OnClick;

public class StoreContractFragmentDark extends StoreContractFragment {

    @Override
    protected int getLayout() {
        return org.recrypt.wallet.R.layout.lyt_store_contract;
    }

    @OnClick(org.recrypt.wallet.R.id.tv_view_abi)
    public void onViewAbiClick() {
        getPresenter().getContractAbiById(getPresenter().getContract().id);
    }

    @Override
    public void setContractData(QstoreContract contract) {
        toolbarTitle.setText(contract.name);
        tvCost.setText(String.valueOf(contract.price));
        tvDescription.setText(contract.description);
        rvTags.setAdapter(new TagRecyclerViewAdapter(contract.tags, this, org.recrypt.wallet.R.layout.item_tag));
        tvPublishDate.setText(DateCalculator.getShortDate(contract.creationDate));
        tvSizeInBytes.setText(String.valueOf(contract.sizeInBytes));
        tvCompiledOn.setText(contract.completedOn);
        tvSourceCode.setText(contract.withSourceCode ? "Yes" : "No");
        tvPublishedBy.setText(contract.publisherAddress);
        tvDownloads.setText(String.valueOf(contract.countDownloads));
    }
}
