package com.liuzhe.rabbitmq.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 忽略routing key的存在，
 * 直接将交换机中的信息广播到所有绑定的Queue中。
 */
@Configuration
public class FanoutConfiguration {

    private static final String FANOUT_A = "fanout.A";
    private static final String FANOUT_B = "fanout.B";
    private static final String FANOUT_C = "fanout.C";

    private static final String FANOUT_EXCHANGE = "fanoutExchange";

    @Bean
    public Queue fanoutQueueA() {
        return new Queue(FANOUT_A);
    }

    @Bean
    public Queue fanoutQueueB() {
        return new Queue(FANOUT_B);
    }

    @Bean
    public Queue fanoutQueueC() {
        return new Queue(FANOUT_C);
    }

    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange(FANOUT_EXCHANGE);
    }

    @Bean
    Binding bindingExchangeA(Queue fanoutQueueA, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(fanoutQueueA).to(fanoutExchange);
    }

    @Bean
    Binding bindingExchangeB(Queue fanoutQueueB, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(fanoutQueueB).to(fanoutExchange);
    }

    @Bean
    Binding bindingExchangeC(Queue fanoutQueueC, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(fanoutQueueC).to(fanoutExchange);
    }

}
