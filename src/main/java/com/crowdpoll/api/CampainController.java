package com.crowdpoll.api;


import com.crowdpoll.donorsChoose.entities.DonorsChooseProposal;
import com.crowdpoll.donorsChoose.repositories.DonorsChooseProposalRepository;
import com.crowdpoll.entities.Campaign;
import com.crowdpoll.entities.CampaignInfo;
import com.crowdpoll.entities.CampaignType;
import com.crowdpoll.entities.CampaignTypes;
import com.crowdpoll.kiva.entities.KivaCampaign;
import com.crowdpoll.kiva.repositories.KivaCampaignRepository;
import com.crowdpoll.repositories.CampaignImageRepository;
import com.crowdpoll.repositories.CampaignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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

    @Autowired
    KivaCampaignRepository kivaCampaignRepository;

    @Autowired
    CampaignImageRepository campaignImageRepository;

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
    @CrossOrigin(origins = "http://localhost:8000")
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
                    KivaCampaign kivaCampaign = kivaCampaignRepository.findByCampaignId( randomCampaignId );
                    kivaCampaign.getCampaign().setImages( campaignImageRepository.findAllByCampaignId( randomCampaignId ) );
                    stuff.add( kivaCampaign );
                    break;
                }
                else if( type == CampaignTypes.DONORSCHOOSE ) {
                    DonorsChooseProposal donorsChooseProposal = donorsChooseProposalRepository.findByCampaignId( randomCampaignId );
                    donorsChooseProposal.getCampaign().setImages( campaignImageRepository.findAllByCampaignId( randomCampaignId ) );
                    stuff.add( donorsChooseProposal );
                    break;
                }
                else {
                    throw new Exception( "Unknown campaign type " + campaignTypeId );
                }
            }
        }

        return stuff;
    }


    /**
     * Return all active campaigns
     *
     * @return
     */
    @GetMapping("/campaign/active")
    @CrossOrigin(origins = "http://localhost:8000")
    public List<Campaign> getActive() {
        return activeCampaigns();
    }

}
