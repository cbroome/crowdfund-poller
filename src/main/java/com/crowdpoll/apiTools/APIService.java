package com.crowdpoll.apiTools;

import com.crowdpoll.entities.Campaign;

import java.util.ArrayList;
import java.util.List;

public class APIService  {

    protected void updateExistingCampaigns(List<Long> existingCampaignIDs, ArrayList<APIDAO> loans) {

        List<KivaLoanDAO> filteredLoans = loans.stream()
                .filter(loan -> existingCampaignIDs.contains(loan.getId()) )
                .collect(Collectors.toList());

        filteredLoans.forEach( loan -> {
            Campaign c = loan.convertToCampaign();
            campaignRepository.save(c);
        });

    }


    protected void saveNewCampaigns(List<Long> existingCampaignIDs, ArrayList<KivaLoanDAO> loans) {

        List<KivaLoanDAO> filteredLoans = loans.stream()
                .filter(loan ->  !existingCampaignIDs.contains(loan.getId()) )
                .collect(Collectors.toList());

        filteredLoans.forEach( loan -> {
            Campaign c = loan.convertToCampaign();
            campaignRepository.save(c);

            // save campaign
            KivaCampaign kc = new KivaCampaign();
            kc.setCampaignId(c.getId());
            kc.setId(loan.getId());
            kivaCampaignRepository.save(kc);

            // save campaign image
            CampaignImage ci = loan.getImage().getCampaignImage();
            ci.setCampaign(c);
            ci.setPrimary(true);
            campaignImageRepository.save(ci);
        });
    }

}
