package com.liuzhe.rabbitmq.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Topic Exchange 转发消息主要是根据通配符。
 * 在这种交换机下，队列和交换机的绑定会定义一种路由模式，那么，
 * 通配符就要在这种路由模式和路由键之间匹配后交换机才能转发消息。
 * 所有匹配到的接收者都能收到发送着发送的消息
 * * 表示一个词.
 * # 表示零个或多个词.
 */
@Configuration
public class TopicConfiguration {

    private static final String MESSAGE_A = "topic.messageA";
    private static final String MESSAGE_B = "topic.messageB";

    private static final String TOPIC_EXCHANGE = "topicExchange";

    @Bean
    public Queue queueMessageA() {
        return new Queue(MESSAGE_A);
    }

    @Bean
    public Queue queueMessageB() {
        return new Queue(MESSAGE_B);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange(TOPIC_EXCHANGE);
    }

    @Bean
    Binding bindingExchangeMessageA(Queue queueMessageA, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessageA).to(exchange).with(MESSAGE_A);
    }

    @Bean
    Binding bindingExchangeMessageB(Queue queueMessageB, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessageB).to(exchange).with("topic.*");
    }

}
