package com.crowdpoll.donorsChoose;

import com.crowdpoll.donorsChoose.dao.DonorsChooseProposalDAO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DonorsChooseResponse {


    protected ArrayList<DonorsChooseProposalDAO> proposals;

    public ArrayList<DonorsChooseProposalDAO> getProposals() {
        return proposals;
    }

    public void setProposals(ArrayList<DonorsChooseProposalDAO> proposals) {
        this.proposals = proposals;
    }
}
