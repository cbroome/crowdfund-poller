package com.crowdpoll.donorsChoose.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DonorsChooseProposalDAO {

    protected long id;

    protected String url;

    protected String shortDescription;

    protected String fulfillmentTrailer;

    protected Date expirationDate;


    public long getId() {
        return id;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public String getFulfillmentTrailer() {
        return fulfillmentTrailer;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getUrl() {
        return url;
    }


    public void setUrl(String url) {
        this.url = url;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public void setFulfillmentTrailer(String fulfillmentTrailer) {
        this.fulfillmentTrailer = fulfillmentTrailer;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }
}
