package com.crowdpoll.api;


import com.crowdpoll.entities.Campaign;
import com.crowdpoll.repositories.CampaignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Random;


@RestController
public class CampainController {


    @Autowired
    CampaignRepository campaignRepository;

    /**
     * Return a random campaign
     *
     * @return {String}
     */
    @GetMapping("/campaign/random")
    public Campaign getRandom() {
        List<Campaign> campaigns = campaignRepository.findAllByEndDateGreaterThan(new Date());
        Campaign randomCampaign = campaigns.get(new Random().nextInt(campaigns.size()));
        return randomCampaign;
    }



    @GetMapping("/campaign/active")
    public List<Campaign> getActive() {
        List<Campaign> campaigns = campaignRepository.findAllByEndDateGreaterThan(new Date());
        return campaigns;
    }

}
