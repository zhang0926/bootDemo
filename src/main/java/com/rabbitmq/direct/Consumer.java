package com.rabbitmq.direct;

import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @Copyright (C), 2019,北京同创永益科技发展有限公司
 * @Package: com.rabbitmq.direct
 * @ClassName: Consumer
 * @author: zhangxiao
 * @Description: 消息消费者
 */
@Component
public class Consumer {

    /**
     * 队列监听
     */
    @RabbitListener(
            bindings = @QueueBinding(value = @Queue(value = "1111", durable = "true"),
            exchange = @Exchange(name = "firstExchange", durable = "true", type = "topic"),
            key = "123.*"
            )
    )
    @RabbitHandler
    public void handleMessage(String message) {
        // 处理消息
        System.out.println("FirstConsumer {} handleMessage :"+message);
    }

}
