package org.recrypt.wallet.ui.fragment.language_fragment;

import org.recrypt.wallet.ui.base.base_fragment.BaseFragmentPresenter;

public interface LanguagePresenter extends BaseFragmentPresenter {
    String getCurrentLanguage();

    void setCurrentLanguage(String language);
}
