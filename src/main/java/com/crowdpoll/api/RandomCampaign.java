package com.crowdpoll.api;


import com.crowdpoll.entities.Campaign;
import com.crowdpoll.repositories.CampaignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;


@RestController
public class RandomCampaign {


    @Autowired
    CampaignRepository campaignRepository;

    /**
     * Return a random campaign
     *
     * @return {String}
     */
    @GetMapping("random")
    public List<Campaign> getRandom() {


        List<Campaign> campaigns = campaignRepository.findAllByEndDateGreaterThan(new Date());

        return campaigns;
    }

}
