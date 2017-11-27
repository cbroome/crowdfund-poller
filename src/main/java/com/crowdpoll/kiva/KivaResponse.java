package com.crowdpoll.kiva;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class KivaResponse {


    protected ArrayList<KivaLoan> loans;


    public ArrayList<KivaLoan> getLoans() {
        return loans;
    }

    public void setLoans(ArrayList<KivaLoan> loans) {
        this.loans = loans;
    }

    @Override
    public String toString() {
        String rv = "Response{";

        if (!loans.isEmpty()) {
            for (KivaLoan loan : loans) {
                rv += loan.toString();
            }
        }
        rv += "}";

        return rv;

    }


}
