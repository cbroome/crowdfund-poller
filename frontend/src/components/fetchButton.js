import React from "react"
import Component from "./component"
import CampaignModel from "../models/campaignModel"

class FetchButton extends Component {

    initialize() {
        this.campaignModel = new CampaignModel();
        this.click = this.click.bind(this);
        this.variable = 'testing';
    }


    /**
     * 
     * @param {GenericModel}    campaign
     */
    buildCampaign( campaign ) {
        console.log("Building campaign", campaign );
    }


    click() {
        this.campaignModel.fetchCampaign( this.buildCampaign.bind( this ) );
    }



    render() {
        return (
            <div className="fetch-button-wrapper" onClick={this.click}>
                <button>Fetch new active campaign</button>
            </div>
        );
    }

}

export default FetchButton;