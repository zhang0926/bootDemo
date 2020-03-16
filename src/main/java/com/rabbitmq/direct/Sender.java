package com.rabbitmq.direct;

import com.rabbitmq.config.RabbitMqConfig;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Copyright (C), 2019,北京同创永益科技发展有限公司
 * @Package: com.rabbitmq.direct
 * @ClassName: Sender
 * @author: zhangxiao
 * @Description: 消息发送者
 */
@Component
public class Sender {

    @Autowired
    private RabbitTemplate template;

    public void send(){
        CorrelationData correlationId = new CorrelationData();
        correlationId.setId("123");
        template.convertAndSend(RabbitMqConfig.EXCHANGE, "123.1", "xiaoxiti", correlationId);
//        EXCHANGE  交换机
//        ROUTINGKEY2  路由键
//        message    消息对象
//        correlationId   消息唯一id

    }
}
