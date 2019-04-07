package com.crowdpoll.donorsChoose.entities;

import com.crowdpoll.entities.Campaign;
import com.crowdpoll.entities.CampaignInfo;

import javax.persistence.*;

@Entity
public class DonorsChooseProposal implements CampaignInfo {

    @Id
    protected Long id;

    @OneToOne
    @JoinColumn(name = "campaign_id")
    protected Campaign campaign;


    @Column(name="school_name")
    protected String schoolName;

    @Column(name="school_url")
    protected String schoolUrl;

    public Campaign getCampaign() {
        return campaign;
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

    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public void setSchoolUrl(String schoolUrl) {
        this.schoolUrl = schoolUrl;
    }

}
