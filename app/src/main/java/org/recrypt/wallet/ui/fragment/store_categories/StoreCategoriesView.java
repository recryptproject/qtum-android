package org.recrypt.wallet.ui.fragment.store_categories;

import org.recrypt.wallet.model.gson.QstoreContractType;
import org.recrypt.wallet.ui.base.base_fragment.BaseFragmentView;

import java.util.List;

public interface StoreCategoriesView extends BaseFragmentView {
    void setUpCategoriesList(List<QstoreContractType> list, StoreCategoryViewHolder.OnCategoryClickListener listener);
}
