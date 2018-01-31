package com.crowdpoll.kiva.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public class KivaLoanDAO {

    protected int id;

    /**
     * Name of the borrower
     */
    protected String name;


    /**
     * Brief description of the loan's intent
     */
    protected String use;


    protected KivaImageDAO image;


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUse() {
        return use;
    }

    public KivaImageDAO getImage() {
        return image;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUse(String use) {
        this.use = use;
    }

    public void setImage(KivaImageDAO image) {
        this.image = image;
    }


    @Override
    public String toString() {
        return "{ id: " + id + ", image: \"" + image.toString() + "\", name: \"" + name + "\", use: \"" + use + "\"}";

    }


}
