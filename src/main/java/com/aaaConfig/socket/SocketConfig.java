package com.aaaConfig.socket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @Copyright (C), 2019,北京同创永益科技发展有限公司
 * @Package: com.aaaConfig.socket
 * @ClassName: SocketConfig
 * @author: zhangxiao
 * @Description: socket配置
 */
@Configuration
@EnableWebSocket
public class SocketConfig {

    /**
     * 自动扫描配置了@ServerEndpoint注解的处理类，并生成实例
     */
    @Bean
    public ServerEndpointExporter serverEndpointExporter(){
        return new ServerEndpointExporter();
    }
    /**
     * 解决websocketConfiguration与@Scheduler冲突的问题
     */
    @Bean
    public ThreadPoolTaskScheduler taskScheduler(){
        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
        taskScheduler.setPoolSize(10);
        taskScheduler.initialize();
        return taskScheduler;
    }

}
