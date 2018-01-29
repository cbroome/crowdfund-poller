package com.crowdpoll.kiva;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.validation.constraints.NotNull;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class KivaLoan {

    @Id
    protected int id;

    /**
     * Name of the borrower
     */
    @NotNull
    protected String name;


    @NotNull
    @JoinColumn(name="campaign_id")
    protected int campaign;

    /**
     * Brief description of the loan's intent
     */
    protected String use;


    protected  KivaImage image;


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUse() {
        return use;
    }

    public KivaImage getImage() {
        return image;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUse(String use) {
        this.use = use;
    }


    public void setImage(KivaImage image) {
        this.image = image;
    }


    @Override
    public String toString() {
        return "{ id: " + id + ", image: \"" + image.getId() + "\", name: \"" + name + "\", use: \"" + use + "\"}";
    }


}
