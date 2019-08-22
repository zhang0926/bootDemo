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
 * @Description: ${description}
 */
@Component
public class Sender {

    @Autowired
    private RabbitTemplate template;

    public void send(){
//        CorrelationData correlationId = new CorrelationData(uuid);
//        template.convertAndSend(RabbitMqConfig.EXCHANGE, RabbitMqConfig.ROUTINGKEY2, message, correlationId);
        String message = "firstQueue" + new Date();
        template.convertAndSend("firstQueue", message);

    }
}
