package com.crowdpoll.apiConsumptionTools;

import com.crowdpoll.entities.Campaign;
import com.crowdpoll.kiva.KivaService;
import com.crowdpoll.repositories.CampaignImageRepository;
import com.crowdpoll.repositories.CampaignRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

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


    /**
     * In case the campaign changed (i.e. end date pushed back) capture the information and update
     *
     * @param existingCampaignIDs
     * @param items
     * @param campaignRepository
     * @return
     */
    protected List<Campaign> updateExistingCampaigns(List<Long> existingCampaignIDs, ArrayList<T> items, CampaignRepository campaignRepository) {
        return returnExisting(existingCampaignIDs, items).stream().map( item -> {

            Campaign c = item.convertToCampaign();

            // TODO: reenable this later...
            // campaignRepository.save(c);

            return c;
        }).collect(Collectors.toList());
    }


    /**
     * Create a new campaign based on the passed item
     *
     * @param existingCampaignIDs
     * @param items
     * @param campaignRepository
     * @return
     */
    protected List<Campaign> saveNewCampaigns(List<Long> existingCampaignIDs, ArrayList<T> items, CampaignRepository campaignRepository) {
         return returnNew(existingCampaignIDs, items).stream().map( item -> {
            Campaign c = item.convertToCampaign();
            log.info( "Saving campaign " + c.getDescription());

            try {
                campaignRepository.save(c);
            } catch (Exception e ) {
                log.error(e.getMessage());
            }

            storeAssociatedData(c, item);
            return c;
         }).collect(Collectors.toList());
    }


    protected RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}
