package fooddelivery.domain;

import fooddelivery.domain.*;
import fooddelivery.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class Cooked extends AbstractEvent {

    private Long id;
    private String food;
    private String address;
    private String status;
    private String orderid;
}


