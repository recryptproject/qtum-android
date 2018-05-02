package org.recrypt.wallet.ui.fragment.overview_fragment;


import org.recrypt.wallet.model.gson.history.History;

public interface OverviewIteractor {
    History getHistory(int position);
}
