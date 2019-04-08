import React from "react"
import Component from "./component"
import CampaignComponent from "./campaignComponent"


class CampaignWrapper extends Component {
    
    render() {
        
        return (
            
            <div>
                <CampaignComponent />
            </div>
            
        );
        
    }
}


export default CampaignWrapper