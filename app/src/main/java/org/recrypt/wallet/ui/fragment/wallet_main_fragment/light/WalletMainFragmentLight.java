package org.recrypt.wallet.ui.fragment.wallet_main_fragment.light;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import org.recrypt.wallet.ui.fragment.wallet_main_fragment.WalletMainFragment;

import butterknife.BindView;

public class WalletMainFragmentLight extends WalletMainFragment implements ViewPager.OnPageChangeListener {

    @BindView(org.recrypt.wallet.R.id.wallet_indicator)
    ImageView walletIndicator;

    @BindView(org.recrypt.wallet.R.id.other_tokens_indicator)
    ImageView otherTokensIndicator;

    @BindView(org.recrypt.wallet.R.id.page_indicator)
    public View pagerIndicator;

    @Override
    protected int getLayout() {
        return org.recrypt.wallet.R.layout.fragment_wallet_main_light;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void initializeViews() {
        super.initializeViews();
        pager.addOnPageChangeListener(this);
    }

    @Override
    public void onPageSelected(int position) {
        if (pagerIndicator.getVisibility() == View.VISIBLE) {
            walletIndicator.setImageResource((position == 0) ? org.recrypt.wallet.R.drawable.tab_indicator_selected_light : org.recrypt.wallet.R.drawable.tab_indicator_default_light);
            otherTokensIndicator.setImageResource((position == 0) ? org.recrypt.wallet.R.drawable.tab_indicator_default_light : org.recrypt.wallet.R.drawable.tab_indicator_selected_light);
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {
    }

    @Override
    public void showPageIndicator() {
        pagerIndicator.setVisibility(View.VISIBLE);
    }

    @Override
    public void hidePageIndicator() {
        pagerIndicator.setVisibility(View.INVISIBLE);
    }
}
