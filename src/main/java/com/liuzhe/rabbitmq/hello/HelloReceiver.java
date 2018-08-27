package com.liuzhe.rabbitmq.hello;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by Alan on 2018/8/24.
 */
@Component
@RabbitListener(queues = "helloQueue")
public class HelloReceiver {

    @RabbitHandler
    public void process(String message) {
        System.out.println("The HelloReceiver received message is : " + message);
    }
}
