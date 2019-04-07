package com.crowdpoll.donorsChoose.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DonorsChooseResponseDAO  {


    protected ArrayList<DonorsChooseProposalDAO> proposals;

    public ArrayList<DonorsChooseProposalDAO> getProposals() {
        return proposals;
    }

    public void setProposals(ArrayList<DonorsChooseProposalDAO> proposals) {
        this.proposals = proposals;
    }
}
