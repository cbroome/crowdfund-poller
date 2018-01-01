package com.crowdpoll.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class Campaign {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;


    @NotNull
    protected String summary;


    @NotNull
    protected String url;


    @NotNull
    protected String description;



}
