package com.crowdpoll.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;


@Entity
public class Campaign {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;


    @NotNull
    protected String summary;


    @NotNull
    protected String url;


    protected String description;



}
