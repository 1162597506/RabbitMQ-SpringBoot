package com.liuzhe.rabbitmq.direct;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.annotation.RabbitListeners;
import org.springframework.stereotype.Component;

/**
 * Created by Alan on 2018/8/27.
 */
@Component
@RabbitListener(queues = {"direct.A","direct.B","direct.C"})
public class DirectReceiver {

    @RabbitHandler
    public void process(String msg) {
        System.out.println("DirectReceiverA  : " + msg);
    }
}

/*
//注解在方法上面
//一个队列一个解决方法
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
*/
