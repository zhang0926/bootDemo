package com.example.bootDemo;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Copyright (C), 2019,北京同创永益科技发展有限公司
 * @Package: com.example.bootDemo
 * @ClassName: WebMvcController
 * @author: zhangxiao
 * @Description: ${description}
 */
@Configuration
public class WebMvcController implements WebMvcConfigurer {

    /**
      * 视图跳转控制器
      */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/a").setViewName("a");
    }
}
