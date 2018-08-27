package com.liuzhe.rabbitmq.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Created by Alan on 2018/8/27.
 */
@Configuration
public class UserConfiguration {

    private static final String USER_QUEUE = "user.queue";

    private static final String USER_TOPIC_EXCHANGE = "userTopicExchange";

    @Bean
    public Queue userQueue() {
        return new Queue(USER_QUEUE);
    }

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(USER_TOPIC_EXCHANGE);
    }

    @Bean
    public Binding directExchangeBinding(Queue userQueue, TopicExchange topicExchange) {
        return BindingBuilder.bind(userQueue).to(topicExchange).with(USER_QUEUE);
    }
}
