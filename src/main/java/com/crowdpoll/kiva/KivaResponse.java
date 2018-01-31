package com.crowdpoll.kiva;

import com.crowdpoll.kiva.dao.KivaLoanDAO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class KivaResponse {


    protected ArrayList<KivaLoanDAO> loans;


    public ArrayList<KivaLoanDAO> getLoans() {
        return loans;
    }

    public void setLoans(ArrayList<KivaLoanDAO> loans) {
        this.loans = loans;
    }

    @Override
    public String toString() {
        String rv = "Response{";

        if (!loans.isEmpty()) {
            for (KivaLoanDAO loan : loans) {
                rv += loan.toString();
            }
        }
        rv += "}";

        return rv;

    }


}
