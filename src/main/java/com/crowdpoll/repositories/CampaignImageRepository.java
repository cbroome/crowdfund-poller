package com.crowdpoll.repositories;

import com.crowdpoll.entities.CampaignImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CampaignImageRepository extends JpaRepository<CampaignImage, Long> {


    List<CampaignImage> findAllByCampaignId( Long campaignId );

}
