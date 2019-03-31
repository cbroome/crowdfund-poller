package com.crowdpoll.api;


import com.crowdpoll.donorsChoose.entities.DonorsChooseProposal;
import com.crowdpoll.donorsChoose.repositories.DonorsChooseProposalRepository;
import com.crowdpoll.entities.Campaign;
import com.crowdpoll.entities.CampaignInfo;
import com.crowdpoll.entities.CampaignType;
import com.crowdpoll.entities.CampaignTypes;
import com.crowdpoll.kiva.repositories.KivaCampaignRepository;
import com.crowdpoll.repositories.CampaignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;


@RestController
public class CampainController {


    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    DonorsChooseProposalRepository donorsChooseProposalRepository;

    @Autowired
    KivaCampaignRepository kivaCampaignRepository;


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
     * @return  Ids for active campaigns
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
     * @exception   thrown for unknown campaign types
     * @return      {String}
     */
    @GetMapping("/campaign/random")
    public Campaign getRandom() {

        List<Campaign> campaigns = activeCampaigns();
        Campaign randomCampaign = campaigns.get( new Random().nextInt( campaigns.size() ) );
        Long randomCampaignId = randomCampaign.getId();

        Long campaignTypeId;
        CampaignInfo stuff;

        // Get additional information about the campaign
        CampaignType ct = randomCampaign.getCampaignType();

        // TODO: find a constant-time way to do this

        for( CampaignTypes type : CampaignType.TYPES.keySet() )  {
            campaignTypeId = CampaignType.TYPES.get( type );
            if( campaignTypeId == ct.getId() ) {
                if( type == CampaignTypes.KIVA ) {
                    stuff = kivaCampaignRepository.findByCampaignId(randomCampaignId);
                }
                else if( type == CampaignTypes.DONORSCHOOSE ) {
                    stuff = donorsChooseProposalRepository.findByCampaignId( randomCampaignId );
                }
            }
        }



        return randomCampaign;
    }



    @GetMapping("/campaign/active")
    public List<Campaign> getActive() {
        return activeCampaigns();
    }

}
