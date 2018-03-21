package com.crowdpoll.kiva;

import com.crowdpoll.kiva.dao.KivaLoanDAO;
import com.crowdpoll.kiva.entities.KivaCampaign;
import com.crowdpoll.kiva.repositories.KivaCampaignRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.crowdpoll.apiTools.API;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class KivaService implements API {

    private static final Logger log = LoggerFactory.getLogger(KivaService.class);

    protected ArrayList<KivaLoanDAO> campaigns;

    protected KivaCampaignRepository repository;

    //protected String queryString = "https://api.kivaws.org/v1/loans/search.json?status=fundraising&country_code=US&q=Baltimore";
    protected String queryString = "https://api.kivaws.org/v1/loans/search.json?status=fundraising&country_code=US";


    protected String getQueryString() {
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


    public void pollForCampaigns() {

        ArrayList<KivaLoanDAO> loans;
        loans = this.search();

        // find existing campaigns
        List<Long> kiva_ids = loans.stream()
               .map( loan -> loan.getId() )
                .collect(Collectors.toList());

        log.info( "Total kiva campaigns: " + kiva_ids.toString() );

        List<KivaCampaign> existingCampaigns = repository.findByIdIn(kiva_ids);

        if( existingCampaigns == null ) {
            log.info( "No existing kiva campaigns");
        } else {
            log.info( "Existing kiva campaigns: " + existingCampaigns.size() );
        }


    }


    public void setRepository(KivaCampaignRepository repository) {
        this.repository = repository;
    }
}
