package fooddelivery.domain;

import fooddelivery.domain.*;
import fooddelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class Cooked extends AbstractEvent {

    private Long id;
    private String food;
    private String address;
    private String status;
    private String orderid;

    public Cooked(StoreOrder aggregate){
        super(aggregate);
    }
    public Cooked(){
        super();
    }
}
