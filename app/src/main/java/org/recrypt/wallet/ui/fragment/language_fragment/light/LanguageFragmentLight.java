package org.recrypt.wallet.ui.fragment.language_fragment.light;

import android.util.Pair;

import org.recrypt.wallet.R;
import org.recrypt.wallet.ui.fragment.language_fragment.LanguageFragment;

import java.util.List;

public class LanguageFragmentLight extends LanguageFragment {
    @Override
    protected int getLayout() {
        return R.layout.fragment_language_light;
    }

    @Override
    public void setUpLanguagesList(List<Pair<String, String>> languagesList) {
        mLanguagesList = languagesList;
        mLanguageAdapter = new LanguageAdapterLight(languagesList, this);
        mRecyclerView.setAdapter(mLanguageAdapter);
    }
}
