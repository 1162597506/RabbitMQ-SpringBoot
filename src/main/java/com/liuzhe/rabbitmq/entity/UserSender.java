package com.liuzhe.rabbitmq.entity;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 使用默认的交换机发送数据
 */
@Component
public class UserSender {

    @Autowired
    AmqpTemplate template;

    public void sendUser() {
        User user = new User(1, "zhangsan", 22);
        System.out.println("the info of user : " + user.toString());
        template.convertAndSend("userTopicExchange", "user.queue", user);
    }

    public void sendString() {
        String user = "it`s just a string  QAQ ";
        template.convertAndSend("userTopicExchange", "user.queue", user);
    }
}
