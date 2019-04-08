import React from "react"
import Component from "./component"
import CampignModel from "../models/campaignModel"


class CampaignComponent extends Component {


    initialize() {
        this.state = {
            summary: '',
            description: '',
            url: '',
            image: ''
        };
        // get an initial campaign 
        this.fetchCampaign();  
    }
    
    
    /**
     * Fetch a campaign from the backend
     * 
     */
    fetchCampaign() {
        let campaignModel = new CampignModel(  );
        campaignModel.fetchCampaign( this.updateCampaignSettings.bind(this) );
    }
    
    
    /**
     * Update the state of the campaign
     * 
     * @param   {GenericModel}  campaign
     */
    updateCampaignSettings( campaign ) {
        this.setState({
            url: campaign.url,
            description: campaign.description,
            summary: campaign.summary,
            image: campaign.image
        });
    }


    render() {
        return (
            <div className="campaign">
                <div>
                    <img src={this.state.image} alt={this.state.summary} />
                </div>
                <div className="summary">
                    {this.state.summary}
                </div>
                <div className="description">
                    {this.state.description}
                </div>
                <div className="url">
                    <a href="{this.state.url}" target="_blank">{this.state.url}</a>  
                </div>
            </div>
        );
    }
}


export default CampaignComponent