package com.liuzhe.rabbitmq.direct;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Alan on 2018/8/27.
 */
@Component
public class DirectSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        String msgA = "This message is sent to direct.A";
        System.out.println("senderA : " + msgA);
        this.rabbitTemplate.convertAndSend("directExchange", "direct.A", msgA);

        String msgB = "This message is sent to direct.B";
        System.out.println("senderB : " + msgB);
        this.rabbitTemplate.convertAndSend("directExchange", "direct.B", msgB);

        String msgC = "This message is sent to direct.C";
        System.out.println("senderC : " + msgC);
        this.rabbitTemplate.convertAndSend("directExchange", "direct.C", msgC);
    }
}
