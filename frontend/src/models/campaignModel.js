import Model from './model';
import KivaModel from './campaign/kivaModel';
import DonorModel from './campaign/donorModel';

class CampaignModel extends Model {

    
    createCampaign( data ) {
        
        let campaignTypes = {
            donorschoose: DonorModel,
            kiva: KivaModel
        };
        let campaignClass = campaignTypes[ data.campaign.campaignType.name ];
        
        if( !campaignClass ) {
            throw 'Could not determine campaign class from ' + data.campaignType.name;   
        }
                
        let campaign = new campaignClass( data.campaign );
        return campaign;
    }
    

    
    /**
     * 
     * 
     * @param   {Object}    response
     * @param   {Function}  hanndler 
     */
    storeCampaignResponse( data, handler ) {
        
        // for the purposes here just take the last campaign off the array
        let campaignData = data.pop();
        let campaign = this.createCampaign( campaignData ); 
        handler( campaign );
    }


    /**
     *
     * @public
     * @param   {Function}
     */
    fetchCampaign( handler ) {

        fetch(
                'campaign/random'
            )
            .then( ( response ) => {
                return response.json();
            } )
            .then( ( data ) => {
                this.storeCampaignResponse( data, handler );
            } );

    }


}

export default CampaignModel;