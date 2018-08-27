package com.liuzhe.rabbitmq.Fanout;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by Alan on 2018/8/27.
 */
@Component
public class FanoutReceiver {

    @RabbitListener(queues = "fanout.A")
    public void processA(String msg) {
        System.out.println("FanoutReceiverA  : " + msg);
    }

    @RabbitListener(queues = "fanout.B")
    public void processB(String msg) {
        System.out.println("FanoutReceiverB  : " + msg);
    }

    @RabbitListener(queues = "fanout.C")
    public void processC(String msg) {
        System.out.println("FanoutReceiverC  : " + msg);
    }

}
