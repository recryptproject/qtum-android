package org.recrypt.wallet.ui.fragment.news_fragment.light;

import org.recrypt.wallet.R;
import org.recrypt.wallet.model.news.News;
import org.recrypt.wallet.ui.activity.main_activity.MainActivity;
import org.recrypt.wallet.ui.fragment.news_fragment.NewsFragment;

import java.util.List;

public class NewsFragmentLight extends NewsFragment {
    @Override
    protected int getLayout() {
        return org.recrypt.wallet.R.layout.fragment_news_light;
    }

    @Override
    public void initializeViews() {
        ((MainActivity) getActivity()).showBottomNavigationView(org.recrypt.wallet.R.color.title_color_light);
        super.initializeViews();
    }

    @Override
    public void updateNews(List<News> newses) {
        mNewsAdapter = new NewsAdapter(newses, R.layout.item_news_light);
        mRecyclerView.setAdapter(mNewsAdapter);
        mSwipeRefreshLayout.setRefreshing(false);
    }
}
