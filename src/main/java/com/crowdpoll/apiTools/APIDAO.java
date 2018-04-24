package com.crowdpoll.apiTools;

import com.crowdpoll.entities.Campaign;

public interface APIDAO {

    /**
     * Convert this object to a Campaign representation.
     *
     * @return
     */
    Campaign convertToCampaign();
}