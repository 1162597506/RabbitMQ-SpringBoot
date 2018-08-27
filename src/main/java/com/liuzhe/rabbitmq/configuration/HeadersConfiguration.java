package com.liuzhe.rabbitmq.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.HeadersExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Headers Exchange不同于其他三种Exchange，
 * 它是根据Message的一些头部信息来分发过滤Message，
 * 忽略routing key的属性，
 * 如果Header信息和message消息的头信息相匹配，
 * 那么这条消息就匹配上了
 */
@Configuration
public class HeadersConfiguration {

    private static final String HEADERS_A = "headers.A";

    private static final String HEADERS_EXCHANGE = "headersExchange";

    @Bean
    public Queue headersQueueA() {
        return new Queue(HEADERS_A);
    }

    @Bean
    HeadersExchange headersExchange() {
        return new HeadersExchange(HEADERS_EXCHANGE);
    }

    @Bean
    Binding bindingHeadersExchangeA(Queue headersQueueA, HeadersExchange headersExchange) {
        // 这里x-match有两种类型
        // all:表示所有的键值对都匹配才能接受到消息
        // any:表示只要有键值对匹配就能接受到消息

        return BindingBuilder.bind(headersExchange).to(headersExchange).where("name").matches("zhangsan");
        // return BindingBuilder.bind(headersQueueA).to(headersExchange).where("age").exists();

    }
}
