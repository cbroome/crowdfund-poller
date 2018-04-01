package com.crowdpoll.apiTools;

import java.util.ArrayList;
import java.util.List;

public interface API<D> {

    <T> ArrayList<T> search();

    /**
     * Update the current campaigns based on the search query.
     */
    void pollForCampaigns() throws Exception;

}
