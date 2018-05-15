package com.crowdpoll.apiTools;

import com.crowdpoll.entities.Campaign;

import java.util.ArrayList;
import java.util.List;

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
