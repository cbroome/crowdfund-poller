package com.crowdpoll.donorsChoose.dao;

import com.crowdpoll.apiConsumptionTools.APIDAO;
import com.crowdpoll.entities.Campaign;
import com.crowdpoll.entities.CampaignImage;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DonorsChooseProposalDAO implements APIDAO {

    protected long id;

    protected String fundURL;

    protected String shortDescription;

    protected String fulfillmentTrailer;

    protected Date expirationDate;

    protected String schoolName;

    protected String schoolUrl;

    protected String imageURL;


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

    public String getFundURL() {
        return fundURL;
    }

    public String getSchoolUrl() {
        return schoolUrl;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setFundURL(String fundURL) {
        this.fundURL = fundURL;
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

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    /**
     * Get a generic capaign representation of the Donor's Choose loan
     *
     * @return Campaign
     */
    public Campaign convertToCampaign() {
        Campaign campaign = new Campaign();

        campaign.setUrl(fundURL);
        campaign.setSummary(fulfillmentTrailer);
        campaign.setDescription(shortDescription);
        campaign.setEndDate(expirationDate);

        return campaign;
    }

    /**
     * Note this does not set the campaign id on purpose.
     *
     * @return CampaignImage
     */
    public CampaignImage createCampaignImage() {
        CampaignImage ci = new CampaignImage();
        ci.setPrimary(true);
        ci.setUrl(imageURL);

        return ci;
    }
}
