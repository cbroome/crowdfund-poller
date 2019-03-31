package com.crowdpoll.kiva.entities;

import com.crowdpoll.entities.Campaign;
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

    @OneToOne
    @JoinColumn(name = "campaign_id")
    protected Campaign campaign;


    public Long getId() {
        return id;
    }

    public Campaign getCampaign() {
        return campaign;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }

}
