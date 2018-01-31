package com.crowdpoll.kiva.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class KivaImageDAO {

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
}
