package com.crowdpoll.apiTools;

import com.crowdpoll.entities.Campaign;
import com.crowdpoll.repositories.CampaignImageRepository;
import com.crowdpoll.repositories.CampaignRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Generic API Service with common functionality.
 *
 */
abstract public class APIService<T extends APIDAO> implements API  {

    protected CampaignRepository campaignRepository;

    protected CampaignImageRepository campaignImageRepository;

    public CampaignImageRepository getCampaignImageRepository() {
        return campaignImageRepository;
    }

    public CampaignRepository getCampaignRepository() {
        return campaignRepository;
    }


    public void setCampaignImageRepository(CampaignImageRepository campaignImageRepository) {
        this.campaignImageRepository = campaignImageRepository;
    }

    public void setCampaignRepository(CampaignRepository campaignRepository) {
        this.campaignRepository = campaignRepository;
    }


    abstract protected List<T> returnExisting(List<Long> existingCampaignIDs, ArrayList<T> items);

    abstract protected List<T> returnNew(List<Long> existingCampaignIDs, ArrayList<T> items);


    abstract protected void storeAssociatedData(Campaign c, T item);

    protected List<Campaign> updateExistingCampaigns(List<Long> existingCampaignIDs, ArrayList<T> items) {
        return returnExisting(existingCampaignIDs, items).stream().map( item -> {
            Campaign c = item.convertToCampaign();
            campaignRepository.save(c);
            return c;
        }).collect(Collectors.toList());
    }


    protected List<Campaign> saveNewCampaigns(List<Long> existingCampaignIDs, ArrayList<T> items) {
         return returnNew(existingCampaignIDs, items).stream().map( item -> {
            Campaign c = item.convertToCampaign();
            campaignRepository.save(c);

            storeAssociatedData(c, item);
            return c;
         }).collect(Collectors.toList());
    }

}
