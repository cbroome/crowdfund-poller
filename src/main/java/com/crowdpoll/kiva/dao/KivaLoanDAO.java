package com.crowdpoll.kiva.dao;

import com.crowdpoll.apiConsumptionTools.APIDAO;
import com.crowdpoll.entities.Campaign;
import com.crowdpoll.entities.CampaignType;
import com.crowdpoll.entities.CampaignTypes;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;


@JsonIgnoreProperties(ignoreUnknown = true)
public class KivaLoanDAO implements APIDAO {

    protected Long id;

    /**
     * Name of the borrower
     */
    protected String name;


    /**
     * Brief description of the loan's intent
     */
    protected String use;


    protected KivaImageDAO image;


    @JsonProperty("planned_expiration_date")
    protected Date plannedExpirationDate;

    @JsonProperty("posted_date")
    protected Date postedDate;


    protected String status;

    @JsonProperty("funded_amount")
    protected Double fundedAmount;



    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUse() {
        return use;
    }

    public KivaImageDAO getImage() { return image; }

    public Date getPlannedExpirationDate() {
        return plannedExpirationDate;
    }

    public Date getPostedDate() {
        return postedDate;
    }

    public Double getFundedAmount() {
        return fundedAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUse(String use) {
        this.use = use;
    }

    public void setImage(KivaImageDAO image) {
        this.image = image;
    }

    public void setFundedAmount(Double fundedAmount) {
        this.fundedAmount = fundedAmount;
    }

    public void setPlannedExpirationDate(Date plannedExpirationDate) {
        this.plannedExpirationDate = plannedExpirationDate;
    }

    public void setPostedDate(Date postedDate) {
        this.postedDate = postedDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }





    @Override
    public String toString() {
        return "{ id: " + id + ", posted: " +postedDate + ", image: \"" + image.toString() + "\", name: \"" + name + "\", use: \"" + use + "\"}";

    }


    public String getPublicURL() {
        return "http://www.kiva.org/lend/" + id;
    }


    /**
     * Get a generic capaign representation of the kiva loan
     *
     * @return Campaign
     */
    public Campaign convertToCampaign() {
        Campaign campaign = new Campaign();

        campaign.setCampaignType(CampaignType.factory(CampaignTypes.KIVA));
        campaign.setSummary(name);
        campaign.setUrl(getPublicURL());
        campaign.setDescription(use);
        campaign.setEndDate(plannedExpirationDate);

        return campaign;
    }



}
