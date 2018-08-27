package com.liuzhe.rabbitmq.headers;

import org.springframework.stereotype.Component;
import java.util.Hashtable;
import java.util.Map;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.core.MessagePropertiesBuilder;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Alan on 2018/8/27.
 */
@Component
public class HeadersSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {

        Map<String, Object> headers = new Hashtable<String, Object>();
        // headers.put("x-match", "any");
        headers.put("x-match", "all");
        headers.put("name", "zhangsan");
        headers.put("age", 30);
        String content = headers.toString();
        MessageProperties props = MessagePropertiesBuilder.newInstance()
                .setContentType(MessageProperties.CONTENT_TYPE_TEXT_PLAIN).setMessageId("123")
                .setHeader("age", "30")
                .build();
        Message message = MessageBuilder.withBody(content.getBytes()).andProperties(props).build();

        System.out.println("sender : " + headers.toString());
        this.rabbitTemplate.convertAndSend("headersExchange", "", message);

    }
}
