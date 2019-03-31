package com.crowdpoll.api;


import com.crowdpoll.donorsChoose.entities.DonorsChooseProposal;
import com.crowdpoll.donorsChoose.repositories.DonorsChooseProposalRepository;
import com.crowdpoll.entities.Campaign;
import com.crowdpoll.repositories.CampaignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;


@RestController
public class CampainController {


    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    DonorsChooseProposalRepository donorsChooseProposalRepository;


    /**
     *
     *
     * @return  Active campaigns (where the end date is in the future)
     */
    protected List<Campaign> activeCampaigns() {
        return campaignRepository.findAllByEndDateGreaterThan(new Date());
    }


    /**
     *
     * @return
     */
    protected List<Long> activeCampaignIds() {
        List<Campaign> activeCampaigns = activeCampaigns();
        return activeCampaigns.stream()
                .map(campaign -> campaign.getId())
                .collect(Collectors.toList());
    }

    /**
     * Return a random campaign
     *
     * @return {String}
     */
    @GetMapping("/campaign/random")
    public Campaign getRandom() {


        List<Campaign> campaigns = campaignRepository.findAllByEndDateGreaterThan(new Date());
        Campaign randomCampaign = campaigns.get(new Random().nextInt(campaigns.size()));

        List<DonorsChooseProposal> donorsChooseProposals = donorsChooseProposalRepository.findByCampaignIdIn(activeCampaignIds());


        return randomCampaign;
    }



    @GetMapping("/campaign/active")
    public List<Campaign> getActive() {
        return activeCampaigns();
    }

}
