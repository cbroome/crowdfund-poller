package com.crowdpoll.entities;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.Set;


@Entity
public class Campaign {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;


    @NotNull
    protected String summary;


    @NotNull
    protected String url;


    protected String description;


    @Column(name="start_date")
    protected Date startDate;


    @Column(name="end_date")
    protected Date endDate;


    @NotNull
    @ManyToOne
    @JoinColumn(name = "campaign_type_id")
    protected CampaignType campaignType;


    @OneToMany(mappedBy = "campaign", cascade = CascadeType.ALL)
    private List<CampaignImage> images;


    public void setId(Long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setImages(List<CampaignImage> images) {
        this.images = images;
    }

    public void setCampaignType(CampaignType campaignType) {
        this.campaignType = campaignType;
    }

    public List<CampaignImage> getImages() {
        return images;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public CampaignType getCampaignType() {
        return campaignType;
    }
}
