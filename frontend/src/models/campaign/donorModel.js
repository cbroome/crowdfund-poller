import GenericModel from './genericModel'

class DonorModel extends GenericModel {
    
    storeAdditionalData( params ) {
        
        this.schoolName = params.schoolName;
        this.schoolUrl = params.schoolUrl;
        
    }
}

export default DonorModel;