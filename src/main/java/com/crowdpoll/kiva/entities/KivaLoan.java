package com.crowdpoll.kiva.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class KivaLoan {

    @Id
    @GeneratedValue
    protected int id;


    protected int campaignId;
}
