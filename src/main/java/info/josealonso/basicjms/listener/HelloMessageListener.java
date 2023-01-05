package info.josealonso.basicjms.listener;

import info.josealonso.basicjms.config.JmsConfig;
import info.josealonso.basicjms.model.HelloWorldMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public class HelloMessageListener {

    private final JmsTemplate jmsTemplate;

    @JmsListener(destination = JmsConfig.MY_QUEUE)
    public void listen(@Payload HelloWorldMessage helloWordMessage,
                       @Headers MessageHeaders headers, Message message) {

        // System.out.println("I received a message !!");

        // System.out.println(helloWordMessage);

        /*   I M P O R T A N T
         If the message client throws an exception, the message
         will get re-queued and redelivered.
         */
    }

    @JmsListener(destination = JmsConfig.MY_SEND_RCV_QUEUE)
    public void listenForHello(@Payload HelloWorldMessage helloWordMessage,
                               @Headers MessageHeaders headers, Message jmsMessage,
                               org.springframework.messaging.Message springMessage) throws JMSException {

        HelloWorldMessage payloadMsg = HelloWorldMessage
                .builder()
                .uuid(UUID.randomUUID())
                .message("Hola, hola !!")
                .build();

        /*
           The Messaging Spring API is different from the JMS one
        */
        // jmsTemplate.convertAndSend(jmsMessage.getJMSReplyTo(), payloadMsg);

        jmsTemplate.convertAndSend((Destination) springMessage.getHeaders().get("jms_replyTo"), "got it");
    }
}


















