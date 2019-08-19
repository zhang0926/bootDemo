package com.aaaConfig.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Copyright (C), 2019,北京同创永益科技发展有限公司
 * @Package: com.example.bootDemo.config.swagger
 * @ClassName: Swagger2Config
 * @author: zhangxiao
 * @Description: swagger文档配置类
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(productApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example"))
                .build();


    }

    private ApiInfo productApiInfo(){
        return new ApiInfoBuilder()
                .title("swagger测试文档")
                .description("简单优雅的restfun风格")
                .termsOfServiceUrl("739144503@qq.com")
                .version("1.0")
                .build();
    }

}
