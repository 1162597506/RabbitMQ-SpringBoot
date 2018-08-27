package com.liuzhe.rabbitmq.topic;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Alan on 2018/8/24.
 */
@Component
public class TopicSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    //根据匹配规则，有两个队列满足两件，所以发送一次，会有两条输出
    public void sendA() {
        String msg = "this is messageA";
        System.out.println("The message sent is :" + msg);
        this.rabbitTemplate.convertAndSend("topicExchange", "topic.messageA", msg);
    }

    public void sendB() {
        String msg = "this is messageB";
        System.out.println("The message sent is :" + msg);
        this.rabbitTemplate.convertAndSend("topicExchange", "topic.messageB", msg);
    }
}
