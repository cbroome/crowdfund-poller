package com.crowdpoll.kiva.entities;

import com.crowdpoll.entities.CampaignInfo;
import com.crowdpoll.entities.CampaignType;

import javax.persistence.*;

@Entity
public class KivaCampaign implements CampaignInfo {

    /**
     * Note the id here maps to Kiva's ID on their API, hence no generation strategy
     */
    @Id
    protected Long id;

    @Column(name="campaign_id")
    protected Long campaignId;

    public Long getId() {
        return id;
    }

    public Long getCampaignId() {
        return campaignId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCampaignId(Long campaignId) {
        this.campaignId = campaignId;
    }

}
