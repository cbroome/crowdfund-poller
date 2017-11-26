package com.crowdpoll.kiva;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.crowdpoll.apiTools.API;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.web.client.RestTemplate;

@JsonIgnoreProperties(ignoreUnknown = true)
public class KivaAPI implements API {

    private static final Logger log = LoggerFactory.getLogger(KivaAPI.class);

    public void search() {

        String url = "http://api.kivaws.org/v1/loans/search.json?status=fundraising";


        RestTemplate restTemplate = new RestTemplate();
        KivaResponse response = restTemplate.getForObject(
                "http://api.kivaws.org/v1/loans/search.json?status=fundraising",
                KivaResponse.class
        );
        log.info(response.toString());


    }




}
