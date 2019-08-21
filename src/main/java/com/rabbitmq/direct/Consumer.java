package com.rabbitmq.direct;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Copyright (C), 2019,北京同创永益科技发展有限公司
 * @Package: com.rabbitmq.direct
 * @ClassName: Consumer
 * @author: zhangxiao
 * @Description: ${description}
 */
@Component
public class Consumer {


    @RabbitListener(queues = {"firstQueue","secondQueue"}, containerFactory = "rabbitListenerContainerFactory")
    public void handleMessage(String message) throws Exception {
        // 处理消息
        System.out.println("FirstConsumer {} handleMessage :"+message);
    }

}
