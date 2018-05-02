package org.recrypt.wallet.ui.fragment.event_log_fragment;

import org.recrypt.wallet.model.gson.history.Log;
import org.recrypt.wallet.ui.base.base_fragment.BaseFragmentView;

import java.util.List;


public interface EventLogView extends BaseFragmentView {
    int getPosition();
    void updateEventLog(List<Log> logs);
}
