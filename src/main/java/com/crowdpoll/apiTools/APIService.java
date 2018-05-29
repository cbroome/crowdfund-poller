package com.crowdpoll.apiTools;

import com.crowdpoll.entities.Campaign;
import com.crowdpoll.kiva.KivaService;
import com.crowdpoll.repositories.CampaignImageRepository;
import com.crowdpoll.repositories.CampaignRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Generic API Service with common functionality.
 *
 */
abstract public class APIService<T extends APIDAO> implements API  {

    private static final Logger log = LoggerFactory.getLogger(KivaService.class);


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

    protected List<Campaign> updateExistingCampaigns(List<Long> existingCampaignIDs, ArrayList<T> items, CampaignRepository campaignRepository) {
        return returnExisting(existingCampaignIDs, items).stream().map( item -> {
            Campaign c = item.convertToCampaign();
            campaignRepository.save(c);
            return c;
        }).collect(Collectors.toList());
    }


    protected List<Campaign> saveNewCampaigns(List<Long> existingCampaignIDs, ArrayList<T> items, CampaignRepository campaignRepository) {
         return returnNew(existingCampaignIDs, items).stream().map( item -> {
            Campaign c = item.convertToCampaign();
            log.info( "Saving campaign " + c.getDescription());

            try {
                campaignRepository.save(c);
            } catch (Exception e ) {
                log.error(e.getMessage());
            }

            log.info( "New id: " + c.getId() );

            //storeAssociatedData(c, item);
            return c;
         }).collect(Collectors.toList());
    }

}
