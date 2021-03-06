package com.crowdpoll.donorsChoose;

import com.crowdpoll.apiConsumptionTools.APIService;
import com.crowdpoll.donorsChoose.dao.DonorsChooseProposalDAO;
import com.crowdpoll.donorsChoose.dao.DonorsChooseResponseDAO;
import com.crowdpoll.donorsChoose.entities.DonorsChooseProposal;
import com.crowdpoll.donorsChoose.repositories.DonorsChooseProposalRepository;
import com.crowdpoll.entities.Campaign;
import com.crowdpoll.entities.CampaignImage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.http.MediaType.TEXT_PLAIN;

public class DonorsChooseService extends APIService<DonorsChooseProposalDAO> {

    private static final Logger log = LoggerFactory.getLogger(DonorsChooseService.class);

    protected String queryString = new String("https://api.donorschoose.org/common/json_feed.html?state=MD&cityName=Baltimore&includeNearbyLocations=false");

    protected DonorsChooseProposalRepository donorsChooseProposalRepository;

    public void setDonorsChooseProposalRepository(DonorsChooseProposalRepository donorsChooseProposalRepository) {
        this.donorsChooseProposalRepository = donorsChooseProposalRepository;
    }

    public DonorsChooseProposalRepository getDonorsChooseProposalRepository() {
        return donorsChooseProposalRepository;
    }

    @Override
    public String getQueryString() {
        return queryString + "&APIKey=DONORSCHOOSE";
    }

    public ArrayList<DonorsChooseProposalDAO> search() {
        RestTemplate restTemplate = new RestTemplate();
        MappingJackson2HttpMessageConverter messageConverter = new MappingJackson2HttpMessageConverter();
        Stack<MediaType> mediaTypes = new Stack<MediaType>();

        mediaTypes.push(TEXT_PLAIN);
        mediaTypes.push(APPLICATION_JSON);

        messageConverter.setSupportedMediaTypes(mediaTypes);
        restTemplate.getMessageConverters().add(messageConverter);

        DonorsChooseResponseDAO response = restTemplate.getForObject(
                getQueryString(),
                DonorsChooseResponseDAO.class
        );

        return response.getProposals();
    }


    public void pollForCampaigns() throws Exception {

        ArrayList<DonorsChooseProposalDAO> proposals = search();
        log.info("Total proposals: " + proposals.size());

        // find existing campaigns
        List<Long> dcIds = proposals.stream()
                .map( proposal -> proposal.getId() )
                .collect(Collectors.toList());

        List<DonorsChooseProposal> existingProposals = donorsChooseProposalRepository.findByIdIn(dcIds);

        if( existingProposals == null ) {
            throw new Exception("Error constructing empty campaigns");
        }

        List<Long> existingCampaignIDs = existingProposals.stream()
                .map( exist -> exist.getId() )
                .collect(Collectors.toList());

        log.info( "Existing donor's choose proposals: {} ", existingProposals.size() );
        updateExistingCampaigns(existingCampaignIDs, proposals, campaignRepository);


        saveNewCampaigns(existingCampaignIDs, proposals, campaignRepository);


    }

    @Override
    protected List<DonorsChooseProposalDAO> returnExisting(List<Long> existingCampaignIDs, ArrayList<DonorsChooseProposalDAO> items) {
        return items.stream()
                .filter(item -> existingCampaignIDs.contains( new Long( item.getId()) ) )
                .collect(Collectors.toList());
    }


    @Override
    protected List<DonorsChooseProposalDAO> returnNew(List<Long> existingCampaignIDs, ArrayList<DonorsChooseProposalDAO> items) {
        return items.stream()
                .filter(item -> !existingCampaignIDs.contains( new Long( item.getId()) ) )
                .collect(Collectors.toList());
    }

    @Override
    protected void storeAssociatedData(Campaign c, DonorsChooseProposalDAO item) {
        linkToProposal(c, item);
        linkToCampaignImage(c, item);
    }

    public void linkToProposal(Campaign campaign, DonorsChooseProposalDAO proposal){
        // save campaign
        DonorsChooseProposal dcp = new DonorsChooseProposal();
        dcp.setCampaign(campaign);
        dcp.setId(proposal.getId());
        dcp.setSchoolUrl(proposal.getSchoolUrl());
        dcp.setSchoolName(proposal.getSchoolName());
        log.info( "Saving donors choose proposal {}", dcp.getId() );
        donorsChooseProposalRepository.save(dcp);
    }

    public void linkToCampaignImage(Campaign campaign, DonorsChooseProposalDAO proposal) {
        CampaignImage ci = proposal.createCampaignImage();
        ci.setCampaign(campaign);
        campaignImageRepository.save(ci);
    }

}
