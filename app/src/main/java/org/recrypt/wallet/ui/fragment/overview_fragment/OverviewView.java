package org.recrypt.wallet.ui.fragment.overview_fragment;


import android.util.Pair;

import org.recrypt.wallet.ui.base.base_fragment.BaseFragmentView;

import java.util.List;

public interface OverviewView extends BaseFragmentView{
    int getPosition();
    void setUpOverview(List<CopyableOverviewItem> overview);
}
