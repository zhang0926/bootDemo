package com.webSocket.stompSocket;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @Copyright (C), 2019,北京同创永益科技发展有限公司
 * @Package: cn.com.hatech.app.dr.sockJS
 * @ClassName: MyInterceptor
 * @Author: zhangxiao
 * @Description: 拦截器
 */

public class MyInterceptor implements HandshakeInterceptor {

    //在握手之前执行该方法, 继续握手返回true, 中断握手返回false. 通过attributes参数设置WebSocketSession的属性
    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse serverHttpResponse, WebSocketHandler webSocketHandler, Map<String, Object> attributes) throws Exception {
        if (request instanceof ServletServerHttpRequest) {
            String ID = request.getURI().toString().split("ID=")[0];
            ServletServerHttpRequest serverHttpRequest = (ServletServerHttpRequest) request;
            HttpSession session = serverHttpRequest.getServletRequest().getSession();
            System.out.println("sessionId  "+ session.getId());
//            attributes.put("WEBSOCKET_USERID",ID);
        }
        return true;
    }
    //完成握手之后执行该方法
    @Override
    public void afterHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse, WebSocketHandler webSocketHandler, Exception e) {
        System.out.println("进来webSocket的afterHandshake拦截器！");
    }


}
