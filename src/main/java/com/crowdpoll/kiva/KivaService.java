package com.crowdpoll.kiva;

import com.crowdpoll.entities.Campaign;
import com.crowdpoll.entities.CampaignImage;
import com.crowdpoll.kiva.dao.KivaLoanDAO;
import com.crowdpoll.kiva.entities.KivaCampaign;
import com.crowdpoll.kiva.repositories.KivaCampaignRepository;
import com.crowdpoll.repositories.CampaignImageRepository;
import com.crowdpoll.repositories.CampaignRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.crowdpoll.apiTools.API;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class KivaService implements API {

    private static final Logger log = LoggerFactory.getLogger(KivaService.class);

    protected KivaCampaignRepository kivaCampaignRepository;


    protected CampaignRepository campaignRepository;

    protected CampaignImageRepository campaignImageRepository;

    //protected String queryString = "https://api.kivaws.org/v1/loans/search.json?status=fundraising&country_code=US&q=Baltimore";
    protected String queryString = "https://api.kivaws.org/v1/loans/search.json?status=fundraising&country_code=US";


    public String getQueryString() {
        return queryString;
    }


    public ArrayList<KivaLoanDAO> search() {
       String url = this.getQueryString();

        RestTemplate restTemplate = new RestTemplate();
        KivaResponse response = restTemplate.getForObject(
                url,
                KivaResponse.class
        );
        log.info(response.toString());

        return response.getLoans();
    }


    public void pollForCampaigns() throws Exception {

        ArrayList<KivaLoanDAO> loans;
        loans = this.search();

        // find existing campaigns
        List<Long> kiva_ids = loans.stream()
               .map( loan -> loan.getId() )
                .collect(Collectors.toList());

        log.info( "Total kiva campaigns: " + kiva_ids.toString() );

        List<KivaCampaign> existingCampaigns = kivaCampaignRepository.findByIdIn(kiva_ids);

        if( existingCampaigns == null ) {
            throw new Exception("Error constructing empty campaigns");
        }

        List<Long> existingCampaignIDs = existingCampaigns.stream()
                .map( exist -> exist.getId() )
                .collect(Collectors.toList());

        log.info( "Existing kiva campaigns: " + existingCampaigns.size() );
        updateExistingCampaigns(existingCampaignIDs, loans);


        saveNewCampaigns(existingCampaignIDs, loans);


    }


    public void setKivaCampaignRepository(KivaCampaignRepository repository) {
        this.kivaCampaignRepository = repository;
    }

    public void setCampaignRepository(CampaignRepository campaignRepository) {
        this.campaignRepository = campaignRepository;
    }

    public void setCampaignImageRepository(CampaignImageRepository campaignImageRepository) {
        this.campaignImageRepository = campaignImageRepository;
    }


    protected void updateExistingCampaigns(List<Long> existingCampaignIDs, ArrayList<KivaLoanDAO> loans) {

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
