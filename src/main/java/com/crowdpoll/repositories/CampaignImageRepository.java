package com.crowdpoll.repositories;

import com.crowdpoll.entities.CampaignImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CampaignImageRepository extends JpaRepository<CampaignImage, Long> {
}
