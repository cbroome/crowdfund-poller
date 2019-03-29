package com.crowdpoll.apiConsumptionTools;

import com.crowdpoll.entities.Campaign;

public interface APIDAO {

    /**
     * Convert this object to a Campaign representation.
     *
     * @return
     */
    Campaign convertToCampaign();

    /**
     *
     *
     * @return  the id of the element's source
     */
    long getId();

}
