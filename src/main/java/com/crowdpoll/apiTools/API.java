package com.crowdpoll.apiTools;

public interface API {

    void search();

    /**
     * Update the current campaigns based on the search query.
     */
    void pollForCampaigns();

}
