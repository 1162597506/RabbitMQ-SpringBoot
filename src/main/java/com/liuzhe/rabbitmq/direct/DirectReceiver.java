package com.liuzhe.rabbitmq.direct;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by Alan on 2018/8/27.
 */
@Component
public class DirectReceiver {

    @RabbitListener(queues = "direct.A")
    public void processA(String msg) {
        System.out.println("DirectReceiverA  : " + msg);
    }

    @RabbitListener(queues = "direct.B")
    public void processB(String msg) {
        System.out.println("DirectReceiverB  : " + msg);
    }

    @RabbitListener(queues = "direct.C")
    public void processC(String msg) {
        System.out.println("DirectReceiverB  : " + msg);
    }
}
