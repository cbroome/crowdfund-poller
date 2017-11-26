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

    @Override
    public String toString() {
        return "{ id: " + id + ", name: \"" + name + "\"}";
    }


}
