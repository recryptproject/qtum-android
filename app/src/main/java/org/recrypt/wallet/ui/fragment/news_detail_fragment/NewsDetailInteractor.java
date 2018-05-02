package org.recrypt.wallet.ui.fragment.news_detail_fragment;

import org.recrypt.wallet.model.news.News;

public interface NewsDetailInteractor {
    News getNews(int newsPosition);
}
