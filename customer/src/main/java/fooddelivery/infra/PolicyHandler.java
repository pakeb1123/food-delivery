package fooddelivery.infra;

import javax.naming.NameParser;

import javax.naming.NameParser;
import javax.transaction.Transactional;

import fooddelivery.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import fooddelivery.domain.*;

@Service
@Transactional
public class PolicyHandler{
    @Autowired NotificationLogRepository notificationLogRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='OrderCanceled'")
    public void wheneverOrderCanceled_NotifyKakao(@Payload OrderCanceled orderCanceled){

        OrderCanceled event = orderCanceled;
        System.out.println("\n\n##### listener NotifyKakao : " + orderCanceled + "\n\n");


        

        // Sample Logic //
        NotificationLog.notifyKakao(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='OrderPlaced'")
    public void wheneverOrderPlaced_NotifyKakao(@Payload OrderPlaced orderPlaced){

        OrderPlaced event = orderPlaced;
        System.out.println("\n\n##### listener NotifyKakao : " + orderPlaced + "\n\n");


        

        // Sample Logic //
        NotificationLog.notifyKakao(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Accepted'")
    public void wheneverAccepted_NotifyKakao(@Payload Accepted accepted){

        Accepted event = accepted;
        System.out.println("\n\n##### listener NotifyKakao : " + accepted + "\n\n");


        

        // Sample Logic //
        NotificationLog.notifyKakao(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Rejected'")
    public void wheneverRejected_NotifyKakao(@Payload Rejected rejected){

        Rejected event = rejected;
        System.out.println("\n\n##### listener NotifyKakao : " + rejected + "\n\n");


        

        // Sample Logic //
        NotificationLog.notifyKakao(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Cooked'")
    public void wheneverCooked_NotifyKakao(@Payload Cooked cooked){

        Cooked event = cooked;
        System.out.println("\n\n##### listener NotifyKakao : " + cooked + "\n\n");


        

        // Sample Logic //
        NotificationLog.notifyKakao(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Delivered'")
    public void wheneverDelivered_NotifyKakao(@Payload Delivered delivered){

        Delivered event = delivered;
        System.out.println("\n\n##### listener NotifyKakao : " + delivered + "\n\n");


        

        // Sample Logic //
        NotificationLog.notifyKakao(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='DeliveryStarted'")
    public void wheneverDeliveryStarted_NotifyKakao(@Payload DeliveryStarted deliveryStarted){

        DeliveryStarted event = deliveryStarted;
        System.out.println("\n\n##### listener NotifyKakao : " + deliveryStarted + "\n\n");


        

        // Sample Logic //
        NotificationLog.notifyKakao(event);
        

        

    }

}


