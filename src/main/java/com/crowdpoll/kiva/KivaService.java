package com.crowdpoll.kiva;

import com.crowdpoll.apiConsumptionTools.APIService;
import com.crowdpoll.entities.Campaign;
import com.crowdpoll.entities.CampaignImage;
import com.crowdpoll.kiva.dao.KivaLoanDAO;
import com.crowdpoll.kiva.dao.KivaResponseDAO;
import com.crowdpoll.kiva.entities.KivaCampaign;
import com.crowdpoll.kiva.repositories.KivaCampaignRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class KivaService extends APIService<KivaLoanDAO> {

    private static final Logger log = LoggerFactory.getLogger(KivaService.class);

    protected KivaCampaignRepository kivaCampaignRepository;

    //protected String queryString = "https://api.kivaws.org/v1/loans/search.json?status=fundraising&country_code=US&q=Baltimore";
    protected String queryString = "https://api.kivaws.org/v1/loans/search.json?status=fundraising&country_code=US";


    public String getQueryString() {
        return queryString;
    }


    public ArrayList<KivaLoanDAO> search() {
       String url = this.getQueryString();

        RestTemplate restTemplate = this.getRestTemplate();
        KivaResponseDAO response = restTemplate.getForObject(
                url,
                KivaResponseDAO.class
        );
        log.info(response.toString());

        return response.getLoans();
    }


    public void pollForCampaigns() throws Exception {

        ArrayList<KivaLoanDAO> kivaLoans;
        kivaLoans = this.search();

        // find existing campaigns
        List<Long> kiva_ids = kivaLoans.stream()
               .map( kivaLoan -> kivaLoan.getId() )
                .collect(Collectors.toList());

        log.info( "Total kiva campaigns: " + kiva_ids.toString() );

        List<KivaCampaign> existingKivaCampaigns = kivaCampaignRepository.findByIdIn(kiva_ids);

        if( existingKivaCampaigns == null ) {
            throw new Exception("Error constructing empty campaigns");
        }

        List<Long> existingKivaIDs = existingKivaCampaigns.stream()
                .map( exist -> exist.getId() )
                .collect(Collectors.toList());

        log.info( "Existing kiva campaigns: " + existingKivaCampaigns.size() );
        updateExistingCampaigns(existingKivaIDs, kivaLoans, campaignRepository);
        saveNewCampaigns(existingKivaIDs, kivaLoans, campaignRepository);

    }


    public void setKivaCampaignRepository(KivaCampaignRepository repository) {
        this.kivaCampaignRepository = repository;
    }


    /**
     * Given a list of existing ids and the full set of items returned by the api response, return
     * those items that already have a corresponding record in the db.
     *
     * @param existingCampaignIDs
     * @param items
     * @return
     */
    @Override
    protected List<KivaLoanDAO> returnExisting(List<Long> existingCampaignIDs, ArrayList<KivaLoanDAO> items) {
        return items.stream()
                .filter(item -> existingCampaignIDs.contains( new Long( item.getId()) ) )
                .collect(Collectors.toList());
    }


    /**
     * Given a list of existing ids and the full set of items returned by the api response, return
     * those items that have not been saved yet.
     *
     * @param existingCampaignIDs
     * @param items
     * @return
     */
    @Override
    protected List<KivaLoanDAO> returnNew(List<Long> existingCampaignIDs, ArrayList<KivaLoanDAO> items) {
        return items.stream()
                .filter(item -> !existingCampaignIDs.contains( new Long( item.getId()) ) )
                .collect(Collectors.toList());
    }


    /**
     *
     * @param c
     * @param item
     */
    protected void storeAssociatedData(Campaign c, KivaLoanDAO item) {
        linkToCampaign(c, item);
        linkToCampaignImage(c, item);
    }

    /**
     *
     * @param campaign
     * @param loan
     */
    public void linkToCampaign(Campaign campaign, KivaLoanDAO loan){
        // save campaign
        KivaCampaign kc = new KivaCampaign();
        kc.setCampaign(campaign);
        kc.setId(loan.getId());
        kivaCampaignRepository.save(kc);
    }

    /**
     *
     * @param campaign
     * @param loan
     */
    public void linkToCampaignImage(Campaign campaign, KivaLoanDAO loan) {
        // save campaign image
        CampaignImage ci = loan.getImage().getCampaignImage();
        ci.setCampaign(campaign);
        ci.setPrimary(true);
        campaignImageRepository.save(ci);
    }
}
