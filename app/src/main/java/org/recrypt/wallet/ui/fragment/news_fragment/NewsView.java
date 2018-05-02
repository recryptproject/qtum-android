package org.recrypt.wallet.ui.fragment.news_fragment;

import org.recrypt.wallet.model.news.News;
import org.recrypt.wallet.ui.base.base_fragment.BaseFragmentView;

import java.util.List;

public interface NewsView extends BaseFragmentView {
    void startRefreshAnimation();

    void setAdapterNull();

    void updateNews(List<News> newses);

    void stopRefreshRecyclerAnimation();
}