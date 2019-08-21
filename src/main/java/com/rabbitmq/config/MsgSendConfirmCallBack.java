package com.rabbitmq.config;

import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

/**
 * @Copyright (C), 2019,北京同创永益科技发展有限公司
 * @Package: com.rabbitmq.config
 * @ClassName: MsgSendConfirmCallBack
 * @author: zhangxiao
 * @Description: ${description}
 */
public class MsgSendConfirmCallBack implements RabbitTemplate.ConfirmCallback{

    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        System.out.println("MsgSendConfirmCallBack  , 回调id:" + correlationData);
        if (ack) {
            System.out.println("消息消费成功");
        } else {
            System.out.println("消息消费失败:" + cause+"\n重新发送");
        }
    }
}
