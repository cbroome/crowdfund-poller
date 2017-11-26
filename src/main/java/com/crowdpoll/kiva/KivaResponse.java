package com.crowdpoll.kiva;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class KivaResponse {


    protected ArrayList<KivaLoan> loans;


    @Override
    public String toString() {
        String rv = "Response{";
        for(KivaLoan loan : loans) {
            rv += loan.toString();
        }
        rv += "}";

        return rv;

    }


}
