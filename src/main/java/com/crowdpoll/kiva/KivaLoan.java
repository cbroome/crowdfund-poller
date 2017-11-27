package com.crowdpoll.kiva;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class KivaLoan {

    protected int id;

    /**
     * Name of the borrower
     */
    protected String name;

    /**
     * Brief description of the loan's intent
     */
    protected String use;


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUse() {
        return use;
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

    @Override
    public String toString() {
        return "{ id: " + id + ", name: \"" + name + "\", use: \"" + use + "\"}";
    }


}
