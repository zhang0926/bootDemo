package com.webSocket.socket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * @Copyright (C), 2019,北京同创永益科技发展有限公司
 * @Package: cn.com.hatech.app.dr.alarm.controller
 * @ClassName: WebSocketConfig
 * @Author: zhangxiao
 * @Description: socket配置类
 */
@Configuration
@EnableWebSocket
@EnableAsync
public class SocketConfig implements WebSocketConfigurer {


    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        // 注册websocket实现类，指定参数访问地址;allowed-origins="*" 允许跨域
        // addHandler是增加处理接口和设定URL
        // addInterceptors增加拦截器处理（可以不用）
        registry.addHandler(myHandler(), "/socket").setAllowedOrigins("*");
        registry.addHandler(myHandler(), "/sockjs/socket").setAllowedOrigins("*").withSockJS();
    }

    @Bean
    public MyHandler myHandler(){
        return new MyHandler();
    }

//    @Bean
//    public MyHandshakeInterceptor myHandshake(){
//        return new MyHandshakeInterceptor();
//    }


}


