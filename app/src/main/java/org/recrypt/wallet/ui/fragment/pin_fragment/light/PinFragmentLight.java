package org.recrypt.wallet.ui.fragment.pin_fragment.light;

import org.recrypt.wallet.ui.activity.main_activity.MainActivity;
import org.recrypt.wallet.ui.fragment.pin_fragment.PinFragment;
import org.recrypt.wallet.ui.wave_visualizer.WaveHelper;
import org.recrypt.wallet.ui.wave_visualizer.WaveView;

import butterknife.BindView;

public class PinFragmentLight extends PinFragment {

    @BindView(org.recrypt.wallet.R.id.wave_view)
    WaveView waveView;
    private WaveHelper mWaveHelper;

    boolean isBottomNavigationViewVisible;

    @Override
    protected int getLayout() {
        return org.recrypt.wallet.R.layout.fragment_pin_light;
    }

    @Override
    public void initializeViews() {
        super.initializeViews();
        isBottomNavigationViewVisible = ((MainActivity) getActivity()).isBottomNavigationViewVisible();
        ((MainActivity) getActivity()).hideBottomNavigationView(org.recrypt.wallet.R.color.title_color_light);
        waveView.setShapeType(WaveView.ShapeType.SQUARE);
        mWaveHelper = new WaveHelper(waveView);
    }

    @Override
    public void onResume() {
        super.onResume();
        mWaveHelper.start();
    }

    @Override
    public void onPause() {
        mWaveHelper.cancel();
        super.onPause();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (isBottomNavigationViewVisible) {
            ((MainActivity) getActivity()).showBottomNavigationView(false);
        } else {
            ((MainActivity) getActivity()).hideBottomNavigationView(org.recrypt.wallet.R.color.title_color_light);
        }
    }
}
