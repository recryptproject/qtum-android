package org.recrypt.wallet.ui.fragment.event_log_fragment;


import org.recrypt.wallet.model.gson.history.History;

public interface EventLogInteractor {
    History getHistory(int position);
}
