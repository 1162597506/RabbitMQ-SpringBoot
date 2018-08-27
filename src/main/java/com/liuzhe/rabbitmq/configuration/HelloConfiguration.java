package com.liuzhe.rabbitmq.configuration;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 使用默认的交换机
 * 通过配置类添加 消息队列queue（建议使用）
 * 若报错找不到队列，
 * 也可以在rabbitmq管理界面手动添加
 */
@Configuration
public class HelloConfiguration {

    @Bean
    public Queue helloQueue() {
        return new Queue("helloQueue");
    }
}
