import Model from '../model'

class GenericModel extends Model {
 
    /**
     * 
     * @param   {Object}
     */
    initialize( params ) {
     
        this.summary = params.summary;
        this.url = params.url;
        this.description = params.description;
        
        if( params.images.length > 0 ) {
               this.image = params.images.pop().url;
        }
        
        this.storeAdditionalData( params );
    }
    
    
    /**
     * Intentional no-op
     * 
     * @param   {Object}    params
     */
    storeAdditionalData( params ) {}
    
}

export default GenericModel;