package info.josealonso.basicjms.listener;

import info.josealonso.basicjms.config.JmsConfig;
import info.josealonso.basicjms.model.HelloWorldMessage;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import javax.jms.Message;

@Component
public class HelloMessageListener {

    @JmsListener(destination = JmsConfig.MY_QUEUE)
    public void listen(@Payload HelloWorldMessage helloWordMessage,
                       @Headers MessageHeaders headers, Message message) {

        System.out.println("I received a message !!");

        System.out.println(helloWordMessage);

        /*   I M P O R T A N T
         If the message client throws an exception, the message
         will get re-queued and redelivered.
         */

    }
}
