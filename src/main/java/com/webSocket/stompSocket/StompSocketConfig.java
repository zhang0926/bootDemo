package com.webSocket.stompSocket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * @Copyright (C), 2019,北京同创永益科技发展有限公司
 * @Package: com.example.demo.stomp
 * @ClassName: WebSocketConfig
 * @Author: zhangxiao
 * @Description: socket配置类
 */
@Configuration
@EnableWebSocketMessageBroker
@EnableAsync  //异步支持
public class StompSocketConfig implements WebSocketMessageBrokerConfigurer {

    //注册stomp协议端点函数
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
//        registry.addEndpoint("/ws/sockJS").addInterceptors(myInterceptor()).setAllowedOrigins("*").withSockJS();
        registry.addEndpoint("/ws/socket2").setAllowedOrigins("*").withSockJS();

    }

    //配置消息代理
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic","/queue","/users/");
//        registry.setApplicationDestinationPrefixes("/app/");
        registry.setUserDestinationPrefix("/users/");
    }


    @Bean
    public MyInterceptor myInterceptor(){
        return new MyInterceptor();
    }
}
