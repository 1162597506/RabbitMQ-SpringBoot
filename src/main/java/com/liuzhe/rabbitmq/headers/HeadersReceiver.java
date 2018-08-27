package com.liuzhe.rabbitmq.headers;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by Alan on 2018/8/27.
 */
@Component
@RabbitListener(queues = "headers.A")
public class HeadersReceiver {

    @RabbitHandler
    public void process(String msg) {
        System.out.println("The HeadersReceiver received message is  : " + msg);
    }
}
