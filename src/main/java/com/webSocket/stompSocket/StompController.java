package com.webSocket.stompSocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

/**
 * @Copyright (C), 2019,北京同创永益科技发展有限公司
 * @Package: com.example.demo.stomp
 * @ClassName: SocketTestController
 * @Author: zhangxiao
 * @Description: ${description}
 */
@Controller
public class StompController {

    @Autowired
    private SimpMessagingTemplate template;

    /**
     * @Description 收到消息并推送给 发送人(一对一)
     * @Param  message 浏览器端发送的参数
     * @return 浏览器端接收的内容
     **/
    @MessageMapping("/testQueueSend")
    @SendToUser("/queue/queueSend")  //订阅路径
    public ResponseMessage testReceiveAndQueueSend(String message) {
        System.out.println("testReceiveAndQueueSend:---" + message);
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setName("zxcvbnmsdfghjk");
        return responseMessage;
    }

    /**
     * @Description 收到消息并推送给 所有人(广播)
     * @Param  message 浏览器端发送的参数
     * @return   浏览器端接收的内容
     **/
    @MessageMapping("/testTopicSend")
    @SendTo("/topic/topicSend")
    public List<String> testReceiveAndTopicSend(String message) {
        System.out.println("testReceiveAndTopicSend:---"+ message);
        List<String> list = new ArrayList<>();
        list.add("123");
        list.add("456");
        list.add("789");
        return list;
    }


    /**
     * @Description 主动定时推送
     * @Param
     * @return
     **/
    @Scheduled(fixedRate = 2000)
    public void sendTopicMessage(){
        System.out.println("后台主动推送");
        List<String> list = new ArrayList<>();
        list.add("456");
        list.add("789");
        template.convertAndSend("/topic/topicSend",list);
    }



}
