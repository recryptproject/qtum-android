package org.recrypt.wallet.ui.fragment.templates_fragment;

import org.recrypt.wallet.model.ContractTemplate;

import java.util.List;

public interface TemplatesInteractor {
    List<ContractTemplate> getContractTemplates();

    int compareDates(String date, String date1);
}
