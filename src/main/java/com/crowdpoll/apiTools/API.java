package com.crowdpoll.apiTools;

import java.util.ArrayList;

public interface API {

    <T> ArrayList<T> search();

    /**
     * Update the current campaigns based on the search query.
     */
    void pollForCampaigns() throws Exception;

}
