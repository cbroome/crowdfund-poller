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

import java.util.*;
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
    public ArrayList<CampaignInfo> getRandom() throws Exception {

        List<Campaign> campaigns = activeCampaigns();
        Campaign randomCampaign = campaigns.get( new Random().nextInt( campaigns.size() ) );
        Long randomCampaignId = randomCampaign.getId();

        Long campaignTypeId;
        ArrayList<CampaignInfo> stuff = new ArrayList<>();

        // Get additional information about the campaign
        CampaignType ct = randomCampaign.getCampaignType();

        // TODO: find a constant-time way to do this
        for( CampaignTypes type : CampaignType.TYPES.keySet() )  {
            campaignTypeId = CampaignType.TYPES.get( type );
            if( campaignTypeId.compareTo(ct.getId()) == 0 ) {
                if( type == CampaignTypes.KIVA ) {
                    stuff.add( kivaCampaignRepository.findByCampaignId( randomCampaignId ) );
                    break;
                }
                else if( type == CampaignTypes.DONORSCHOOSE ) {
                    stuff.add( donorsChooseProposalRepository.findByCampaignId( randomCampaignId ) );
                    break;
                }
                else {
                    throw new Exception( "Unknown campaign type " + campaignTypeId );
                }
            }
        }



        return stuff;
    }



    @GetMapping("/campaign/active")
    public List<Campaign> getActive() {
        return activeCampaigns();
    }

}
