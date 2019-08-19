package com.webSocket.socket;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.socket.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Copyright (C), 2019,北京同创永益科技发展有限公司
 * @Package: cn.com.hatech.app.dr.sockJS
 * @ClassName: EchoHandler
 * @Author: zhangxiao
 * @Description: socket处理类
 */

public class MyHandler implements WebSocketHandler {


    //在线用户列表
    private static  Map<String, WebSocketSession> users = new HashMap<>();

    //连接建立处理
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("123456");

    }

    //接收、发送处理
    @Scheduled(fixedRate = 10000)
    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        System.out.println(session.getId());
        System.out.println(message);
        session.sendMessage(new TextMessage("5678"));

    }

    @Override
    public void handleTransportError(WebSocketSession webSocketSession, Throwable throwable) throws Exception {

    }

    //连接断开处理
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {

    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }

    //发送给指定用户
    public boolean sendMessageToUser(String clientId, TextMessage message) {
        if (users.get(clientId) == null) {
            return false;
        }
        WebSocketSession session = users.get(clientId);
        System.out.println("sendMessage:" + session);
        if (!session.isOpen()) {
            return false;
        }
        try {
            session.sendMessage(message);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    //广播消息
    public boolean sendMessageToAllUsers(TextMessage message) {
        boolean allSendSuccess = true;
        Set<String> clientIds = users.keySet();
        WebSocketSession session = null;
        for (String clientId : clientIds) {
            try {
                session = users.get(clientId);
                if (session.isOpen()) {
                    session.sendMessage(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
                allSendSuccess = false;
            }
        }
        return  allSendSuccess;
    }

    //获得用户标识
    private String getClientId(WebSocketSession session) {
        try {
            String clientId =  session.getId();
            return clientId;
        } catch (Exception e) {
            return null;
        }
    }


}
