package org.recrypt.wallet.ui.fragment.about_fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import org.recrypt.wallet.model.Version;
import org.recrypt.wallet.ui.base.base_fragment.BaseFragment;
import org.recrypt.wallet.ui.fragment_factory.Factory;
import org.recrypt.wallet.utils.FontTextView;

import butterknife.BindView;
import butterknife.OnClick;

public abstract class AboutFragment extends BaseFragment implements AboutView {

    AboutPresenter mAboutFragmentPresenter;

    @OnClick({org.recrypt.wallet.R.id.ibt_back})
    public void onClick(View view) {
        switch (view.getId()) {
            case org.recrypt.wallet.R.id.ibt_back:
                getActivity().onBackPressed();
                break;
        }
    }

    @BindView(org.recrypt.wallet.R.id.tv_recrypt_version)
    FontTextView mTextViewRecryptVersion;

    public static BaseFragment newInstance(Context context) {
        Bundle args = new Bundle();
        BaseFragment fragment = Factory.instantiateFragment(context, AboutFragment.class);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void updateVersion(Version version) {
        String footer = getString(org.recrypt.wallet.R.string._2017_recrypt_n_skynet_testnet_version) + "Version " + version.getVersionName() + "(" + String.valueOf(version.getVersionCode()) + ")";
        mTextViewRecryptVersion.setText(footer);
    }

    @Override
    protected void createPresenter() {
        mAboutFragmentPresenter = new AboutPresenterImpl(this, new AboutInteractorImpl(getContext()));
    }

    @Override
    protected AboutPresenter getPresenter() {
        return mAboutFragmentPresenter;
    }
}