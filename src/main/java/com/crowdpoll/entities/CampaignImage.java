package com.crowdpoll.entities;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class CampaignImage {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;


    @NotNull
    protected String url;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "campaign_id")
    protected Campaign campaign;


    protected Boolean isPrimary;


    public void setId(long id) {
        this.id = id;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }

    public void setPrimary(Boolean primary) {
        isPrimary = primary;
    }
}
