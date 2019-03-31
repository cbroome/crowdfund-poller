package com.crowdpoll.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Entity
public class CampaignType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;


    protected String name;


    public CampaignType(Long id) {
        this.id = id;
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }


    public static final Map<CampaignTypes, Long> TYPES;
    static {
        Map<CampaignTypes, Long> tempMap = new HashMap<CampaignTypes, Long>();
        tempMap.put(CampaignTypes.KIVA, new Long( 1 ));
        tempMap.put(CampaignTypes.DONORSCHOOSE, new Long(2));
        TYPES = Collections.unmodifiableMap(tempMap);
    }


    public static CampaignType factory( CampaignTypes type ) {
        return new CampaignType( TYPES.get(type) );
    }

}



