package org.recrypt.wallet.ui.fragment.smart_contracts_fragment.light;

import org.recrypt.wallet.R;
import org.recrypt.wallet.ui.fragment.profile_fragment.SettingObject;
import org.recrypt.wallet.ui.fragment.smart_contracts_fragment.SmartContractsFragment;

import java.util.ArrayList;
import java.util.List;

public class SmartContractsFragmentLight extends SmartContractsFragment {

    private List<SettingObject> settingsData;

    @Override
    protected int getLayout() {
        return org.recrypt.wallet.R.layout.fragment_smart_contracts_light;
    }

    @Override
    public void initializeViews() {
        super.initializeViews();
        settingsData = new ArrayList<>();
        settingsData.add(new SettingObject(org.recrypt.wallet.R.string.my_new_contracts, org.recrypt.wallet.R.drawable.ic_my_new_contracts_light, 0));
        settingsData.add(new SettingObject(org.recrypt.wallet.R.string.my_published_contracts, org.recrypt.wallet.R.drawable.ic_my_published_contracts_light, 0));
        settingsData.add(new SettingObject(R.string.contracts_store, R.drawable.recrypt_logo, 0));
        settingsData.add(new SettingObject(org.recrypt.wallet.R.string.watch_contract, org.recrypt.wallet.R.drawable.ic_contr_watch_light, 0));
        settingsData.add(new SettingObject(org.recrypt.wallet.R.string.watch_token, org.recrypt.wallet.R.drawable.ic_token_watch_light, 0));
        settingsData.add(new SettingObject(org.recrypt.wallet.R.string.backup_contracts, org.recrypt.wallet.R.drawable.ic_contract_backup_light, 0));
        settingsData.add(new SettingObject(org.recrypt.wallet.R.string.restore_contracts, org.recrypt.wallet.R.drawable.ic_contract_restore_light, 0));
        initializeList(org.recrypt.wallet.R.layout.lyt_profile_pref_list_item_light, org.recrypt.wallet.R.drawable.color_primary_divider_light, org.recrypt.wallet.R.drawable.section_setting_divider_light, settingsData);
    }
}
