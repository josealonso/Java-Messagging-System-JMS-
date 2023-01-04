package info.josealonso.basicjms.sender;

import info.josealonso.basicjms.config.JmsConfig;
import info.josealonso.basicjms.model.HelloWorldMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.UUID;

@RequiredArgsConstructor
@Component
public class HelloSender {

    private final JmsTemplate jmsTemplate;

    @Scheduled(fixedRate = 1500)
    public void sendMessage() {

        System.out.println("I'm sending a message ===== ");

        HelloWorldMessage message = HelloWorldMessage
                .builder()
                .uuid(UUID.randomUUID())
                .message("Hola mundo")
                .build();

        jmsTemplate.convertAndSend(JmsConfig.MY_QUEUE, message);

        System.out.println("Message sent !! ==========");
    }
}
