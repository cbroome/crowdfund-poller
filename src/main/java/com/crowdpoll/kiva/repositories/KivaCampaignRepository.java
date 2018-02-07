package com.crowdpoll.kiva.repositories;

import com.crowdpoll.kiva.entities.KivaCampaign;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface KivaCampaignRepository extends JpaRepository<KivaCampaign, Long> {

    List<KivaCampaign> findByIdIn(List<Long> ids);

}
