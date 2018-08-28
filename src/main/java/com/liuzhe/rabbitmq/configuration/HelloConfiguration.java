package com.liuzhe.rabbitmq.configuration;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 使用默认的交换机（实际上是一个由消息代理预先声明好的没有名字（名字为空字符串）的直连交换机（direct exchange））
 * 它有一个特殊的属性使得它对于简单应用特别有用处：那就是每个新建队列（queue）都会自动绑定到默认交换机上，
 * 绑定的路由键（routing key）名称与队列名称相同。
 *
 * 多个监听一个队列的消费者每次只有一个消费者可以收到消息，
 * 消息的负载均衡也是发生在消费者之间的，即RabbitMQ会通过消息轮询机制来选择消费者。
 *
 * 通过配置类添加消息队列queue（建议使用）
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
