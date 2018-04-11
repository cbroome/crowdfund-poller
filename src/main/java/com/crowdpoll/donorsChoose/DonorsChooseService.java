package com.crowdpoll.donorsChoose;

import com.crowdpoll.apiTools.API;
import com.crowdpoll.donorsChoose.dao.DonorsChooseProposalDAO;
import com.crowdpoll.donorsChoose.dao.DonorsChooseResponseDAO;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class DonorsChooseService implements API {


    protected String queryString = new String("https://api.donorschoose.org/common/json_feed.html?state=MD&cityName=Baltimore&includeNearbyLocations=false");


    @Override
    public String getQueryString() {
        return queryString + "&APIKey=DONORSCHOOSE";
    }

    public ArrayList<DonorsChooseProposalDAO> search() {
        RestTemplate restTemplate = new RestTemplate();
        DonorsChooseResponseDAO response = restTemplate.getForObject(
                getQueryString(),
                DonorsChooseResponseDAO.class
        );

        return response.getProposals();
    }


    public void pollForCampaigns() throws Exception {

    }


    protected void updateExistingCampaigns(List<Long> existingCampaignIDs, ArrayList<DonorsChooseProposalDAO> loans) {

    }

    protected void saveNewCampaigns(List<Long> existingCampaignIDs, ArrayList<DonorsChooseProposalDAO> loans) {

    }

}
