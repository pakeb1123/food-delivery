package fooddelivery.external;

import lombok.Data;
import java.util.Date;
@Data
public class Order {

    private Long id;
    private String food;
    private String cutomerid;
    private String address;
    private String price;
    private String status;
}


