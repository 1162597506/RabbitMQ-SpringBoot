package com.liuzhe.rabbitmq.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 直接匹配，一个萝卜一个坑
 * 没有坑的萝卜没地方放
 */
@Configuration
public class DirectConfiguration {

    private final static String DIRECT_A = "direct.A";
    private final static String DIRECT_B = "direct.B";
    private final static String DIRECT_C = "direct.C";

    @Bean
    public Queue directQueueA() {
        return new Queue(DIRECT_A);
    }

    @Bean
    public Queue directQueueB() {
        return new Queue(DIRECT_B);
    }

    @Bean
    public Queue directQueueC() {
        return new Queue(DIRECT_C);
    }

    @Bean
    DirectExchange directExchange() {
        return new DirectExchange("directExchange");
    }

    @Bean
    Binding bindingDirectExchangeA(Queue directQueueA, DirectExchange directExchange) {
        return BindingBuilder.bind(directQueueA).to(directExchange).with(DIRECT_A);
    }

    @Bean
    Binding bindingDirectExchangeB(Queue directQueueB, DirectExchange directExchange) {
        return BindingBuilder.bind(directQueueB).to(directExchange).with(DIRECT_B);
    }

    @Bean
    Binding bindingDirectExchangeC(Queue directQueueC, DirectExchange directExchange) {
        return BindingBuilder.bind(directQueueC).to(directExchange).with(DIRECT_C);
    }
}
