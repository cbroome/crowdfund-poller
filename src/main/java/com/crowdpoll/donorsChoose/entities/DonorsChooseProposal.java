package com.crowdpoll.donorsChoose.entities;

import com.crowdpoll.entities.CampaignInfo;
import com.crowdpoll.entities.CampaignType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DonorsChooseProposal implements CampaignInfo {

    @Id
    protected Long id;

    @Column(name="campaign_id")
    protected Long campaignId;


    @Column(name="school_name")
    protected String schoolName;

    @Column(name="school_url")
    protected String schoolUrl;


    public Long getCampaignId() {
        return campaignId;
    }

    public Long getId() {
        return id;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public String getSchoolUrl() {
        return schoolUrl;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCampaignId(Long campaignId) {
        this.campaignId = campaignId;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public void setSchoolUrl(String schoolUrl) {
        this.schoolUrl = schoolUrl;
    }

}
