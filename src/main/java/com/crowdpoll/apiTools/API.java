package com.crowdpoll.apiTools;

import java.util.ArrayList;
import java.util.List;

public interface API {

    /**
     * Return an ArrayList of items from the search
     *
     * @param <T>
     * @return
     */
    <T> ArrayList<T> search();

    /**
     * Update the current campaigns based on the search query.
     */
    void pollForCampaigns() throws Exception;


    String getQueryString();

}
