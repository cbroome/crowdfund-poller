package com.crowdpoll.apiConsumptionTools;

import java.util.ArrayList;

public interface API{

    /**
     * Return an ArrayList of items from the search
     *
     * @param
     * @return
     */
    ArrayList<? extends APIDAO> search();

    /**
     * Update the current campaigns based on the search query.
     */
    void pollForCampaigns() throws Exception;



    String getQueryString();

}
