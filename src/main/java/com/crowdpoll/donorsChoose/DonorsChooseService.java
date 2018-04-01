package com.crowdpoll.donorsChoose;

import com.crowdpoll.apiTools.API;
import com.crowdpoll.donorsChoose.dao.DonorsChooseCampaignDAO;

import java.util.ArrayList;
import java.util.List;

public class DonorsChooseService implements API<DonorsChooseCampaignDAO> {


    public ArrayList<DonorsChooseCampaignDAO> search() {
        ArrayList<DonorsChooseCampaignDAO> rv = new ArrayList<DonorsChooseCampaignDAO>();

        return rv;
    }


    public void pollForCampaigns() throws Exception {

    }


    protected void updateExistingCampaigns(List<Long> existingCampaignIDs, ArrayList<DonorsChooseCampaignDAO> loans) {

    }

    protected void saveNewCampaigns(List<Long> existingCampaignIDs, ArrayList<DonorsChooseCampaignDAO> loans) {

    }

}
