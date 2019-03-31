package com.crowdpoll.donorsChoose.repositories;

import com.crowdpoll.donorsChoose.entities.DonorsChooseProposal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DonorsChooseProposalRepository  extends JpaRepository<DonorsChooseProposal, Long> {

    List<DonorsChooseProposal> findByIdIn(List<Long> ids);


    List<DonorsChooseProposal> findByCampaignIdIn(List<Long> ids);


    DonorsChooseProposal findByCampaignId(Long campaignId);


}
