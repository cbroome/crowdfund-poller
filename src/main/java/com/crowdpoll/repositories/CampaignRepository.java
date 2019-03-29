package com.crowdpoll.repositories;

import com.crowdpoll.entities.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface CampaignRepository extends JpaRepository<Campaign, Long> {


    List<Campaign> findAllByEndDateGreaterThan(Date date);

}
