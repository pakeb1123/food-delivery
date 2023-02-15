package fooddelivery.domain;

import fooddelivery.domain.OrderCanceled;
import fooddelivery.domain.OrderPlaced;
import fooddelivery.AppApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Entity
@Table(name="Order_table")
@Data

public class Order  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private String food;
    
    
    
    
    
    private String cutomerid;
    
    
    
    
    
    private String address;
    
    
    
    
    
    private String price;
    
    
    
    
    
    private String status;

    @PostPersist
    public void onPostPersist(){


        OrderCanceled orderCanceled = new OrderCanceled(this);
        orderCanceled.publishAfterCommit();


        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.


        fooddelivery.external.Payment payment = new fooddelivery.external.Payment();
        // mappings goes here
        AppApplication.applicationContext.getBean(fooddelivery.external.PaymentService.class)
            .pay(payment);


        OrderPlaced orderPlaced = new OrderPlaced(this);
        orderPlaced.publishAfterCommit();

        // Get request from Payment
        //fooddelivery.external.Payment payment =
        //    Application.applicationContext.getBean(fooddelivery.external.PaymentService.class)
        //    .getPayment(/** mapping value needed */);

    }
    @PreUpdate
    public void onPreUpdate(){
    }

    public static OrderRepository repository(){
        OrderRepository orderRepository = AppApplication.applicationContext.getBean(OrderRepository.class);
        return orderRepository;
    }




    public static void updateStatus(Rejected rejected){

        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */

        /** Example 2:  finding and process
        
        repository().findById(rejected.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);


         });
        */

        
    }
    public static void updateStatus(Accepted accepted){

        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */

        /** Example 2:  finding and process
        
        repository().findById(accepted.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);


         });
        */

        
    }


}
