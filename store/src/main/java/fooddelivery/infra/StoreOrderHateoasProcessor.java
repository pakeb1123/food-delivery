package fooddelivery.infra;
import fooddelivery.domain.*;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import org.springframework.hateoas.EntityModel;

@Component
public class StoreOrderHateoasProcessor implements RepresentationModelProcessor<EntityModel<StoreOrder>>  {

    @Override
    public EntityModel<StoreOrder> process(EntityModel<StoreOrder> model) {

        
        return model;
    }
    
}
