package com.liuzhe.rabbitmq.topic;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by Alan on 2018/8/24.
 */
@Component
public class TopicReceiver {

    @RabbitListener(queues = "topic.messageA")
    public void processA(String message) {
        System.out.println("The  processA received message is : " + message);
    }

    @RabbitListener(queues = "topic.messageB")
    public void processB(String message) {
        System.out.println("The  processB received message is : " + message);
    }
}
