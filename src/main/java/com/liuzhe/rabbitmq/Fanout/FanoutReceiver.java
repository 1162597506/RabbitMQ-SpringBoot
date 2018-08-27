package com.liuzhe.rabbitmq.Fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
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

/*
//这种注解方式也可以，不过控制台输出的结果不是很明显
@Component
@RabbitListener(queues = {"fanout.A","fanout.B","fanout.C"})
public class FanoutReceiver {

    @RabbitHandler
    public void process(String msg) {
        System.out.println("FanoutReceiver  : " + msg);
    }

}*/
