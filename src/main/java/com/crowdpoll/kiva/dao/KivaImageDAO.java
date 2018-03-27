package com.crowdpoll.kiva.dao;

import com.crowdpoll.entities.CampaignImage;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class KivaImageDAO {

    protected int size = 1024;

    protected int id;

    protected int templateId;

    public void setTemplate_id(int templateId) {
        this.templateId = templateId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTemplateId() {
        return templateId;
    }

    public int getId() {
        return id;
    }

    public CampaignImage getCampaignImage() {
        CampaignImage ci = new CampaignImage();
        ci.setId(id);
        // TODO: should be resolved by a service call
        ci.setUrl("http://www.kiva.org/img/"+ size +"/"+id+".jpg");
        return ci;

    }
}
