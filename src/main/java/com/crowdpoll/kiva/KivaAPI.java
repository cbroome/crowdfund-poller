package com.crowdpoll.kiva;

import com.crowdpoll.kiva.dao.KivaLoanDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.crowdpoll.apiTools.API;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;


@JsonIgnoreProperties(ignoreUnknown = true)
public class KivaAPI implements API {

    private static final Logger log = LoggerFactory.getLogger(KivaAPI.class);

    protected ArrayList<KivaLoanDAO> campaigns;

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

    }




}
