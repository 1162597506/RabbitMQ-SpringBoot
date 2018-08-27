package com.liuzhe.rabbitmq.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * direct 模式配置类
 * queue和 exchange 需要匹配的必须一个一个的绑定好
 */
@Configuration
public class DirectConfiguration {

    private static final String DIRECT_A = "direct.A";
    private static final String DIRECT_B = "direct.B";
    private static final String DIRECT_C = "direct.C";

    private static final String DIRECT_EXCHANGE = "directExchange";

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
        return new DirectExchange(DIRECT_EXCHANGE);
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
