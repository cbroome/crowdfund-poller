package com.crowdpoll.kiva.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class KivaCampaign {

    @Id
    @GeneratedValue
    protected Long id;

    @Column(name="campaign_id")
    protected Long campaignId;
}
