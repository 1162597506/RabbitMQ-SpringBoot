package com.liuzhe.rabbitmq.hello;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Created by Alan on 2018/8/24.
 */
@Component
public class HelloReceiver {

    /**
     * 我们在搭建一个消息队列时候，我们的思路应该是这样的，
     * 首先，我们要启动ack的手动方式，
     * 然后，当我们处理代码逻辑时，如果发生了异常信息，
     * 我们首先通知到ack，表示我接受到这条数据了，消息缓存中可以删除原数据了，并且不让消息自动的重新进入队列中，
     * 然后，我们启用一个错误处理，手动将其重新插入队列中，
     *
     * 注意：如果使用手动方式，千万不能忘记应答消息，不然会出现消息队列阻塞，影响业务执行
     *      手动开启需要在配置文件中配置  acknowledge-mode: manual
     */
    @RabbitListener(queues = "helloQueue")
    public void process(Message message, Channel channel) throws IOException {
        //通过 message 对象获取发送过来的数据信息
        System.out.println("The HelloReceiver received message is : " + new String(message.getBody()));

        //消息处理正常，没有抛出异常，这时我们需要手动应答消息,message将从rabbitmq的消息缓存中移除
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);

        //拒绝一个或多个接收到的消息
        //第二个参数为true，则拒绝所有消息，false则只拒绝现在这条消息
        //第三个参数，如果被拒绝的消息应该被请求而不是丢弃，则为真。
        channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);

        //拒绝本条消息
        channel.basicReject(message.getMessageProperties().getDeliveryTag(), true);

        //路由不成功的消息可以使用recovery重新发送到队列中
        //参数为true则消息将被请求和可能交付给不同的消费者。
        //如果为false，消息将为重新交付给同一个消费者。
        channel.basicRecover(true);


    }
}
