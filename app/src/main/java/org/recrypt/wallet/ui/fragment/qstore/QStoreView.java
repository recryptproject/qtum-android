package org.recrypt.wallet.ui.fragment.qstore;

import org.recrypt.wallet.model.gson.qstore.QSearchItem;
import org.recrypt.wallet.ui.base.base_fragment.BaseFragmentView;
import org.recrypt.wallet.ui.fragment.qstore.categories.QstoreCategory;

import java.util.List;

public interface QStoreView extends BaseFragmentView {
    void setCategories(List<QstoreCategory> categories);

    void setSearchResult(List<QSearchItem> items);

    void setSearchBarText(String text);

    String getSeacrhBarText();
}
