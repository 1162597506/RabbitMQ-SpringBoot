package com.liuzhe.rabbitmq.entity;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by Alan on 2018/8/27.
 */
@Component
@RabbitListener(queues = "user.queue")
public class UserReceiver {

    @RabbitHandler
    public void receiverUser(User user) {
        System.out.println("the recevied userinfo is : " + user.toString());
    }

    @RabbitHandler
    public void receiverString(String str) {
        System.out.println("the recevied String is : " + str);
    }
}
