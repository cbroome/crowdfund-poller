package com.crowdpoll.donorsChoose.dao;

import com.crowdpoll.apiTools.APIDAO;
import com.crowdpoll.entities.Campaign;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DonorsChooseProposalDAO implements APIDAO {

    protected long id;

    protected String url;

    protected String shortDescription;

    protected String fulfillmentTrailer;

    protected Date expirationDate;

    protected  String schoolName;

    protected  String schoolUrl;


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

    public String getSchoolUrl() {
        return schoolUrl;
    }

    public String getSchoolName() {
        return schoolName;
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

    public void setSchoolUrl(String schoolUrl) {
        this.schoolUrl = schoolUrl;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }


    /**
     * Get a generic capaign representation of the kiva loan
     *
     * @return Campaign
     */
    public Campaign convertToCampaign() {
        Campaign campaign = new Campaign();

        campaign.setUrl(url);
        campaign.setSummary(fulfillmentTrailer);
        campaign.setDescription(shortDescription);
        campaign.setEnd_date(expirationDate);

        return campaign;
    }
}
