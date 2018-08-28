# SpringBoot整合RabbitMQ
springboot整合RabbitMQ，编写了一些简单的小栗子，帮助学习RabbitMQ
- 简单实现topic、fanout、direct和headers四种交换机的使用。
- 在entity的demo中，使用同一个队列，根据发送不同的数据类型（对象，字符串），完成相应的数据处理。
- 在hello的demo中，添加消息处理的四种方式（接受并处理、拒绝一条、拒绝本条及以后的所有消息、消息重新发送）