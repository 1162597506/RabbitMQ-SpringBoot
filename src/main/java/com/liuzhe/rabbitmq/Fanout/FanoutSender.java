package com.liuzhe.rabbitmq.Fanout;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by Alan on 2018/8/27.
 */
@Component
public class FanoutSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        String sendMsg = " This message is sent by fanout. ";
        System.out.println("fanoutSender : " + sendMsg);
        this.rabbitTemplate.convertAndSend("fanoutExchange","", sendMsg);
    }
}
