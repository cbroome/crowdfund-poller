package com.crowdpoll.models;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
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

}
