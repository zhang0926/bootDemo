package com.rabbitmq.controller;

import com.rabbitmq.direct.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @Copyright (C), 2019,北京同创永益科技发展有限公司
 * @Package: com.rabbitmq.controller
 * @ClassName: SendController
 * @author: zhangxiao
 * @Description: ${description}
 */
@RestController
public class SendController {


    @Autowired
    private Sender firstSender;

    @GetMapping("/send")
    public String send(String message){
        String uuid = UUID.randomUUID().toString();
        firstSender.send();
        return uuid;
    }

}
