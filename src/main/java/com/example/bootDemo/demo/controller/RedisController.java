package com.example.bootDemo.demo.controller;

import com.example.bootDemo.demo.service.IRedisService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Copyright (C), 2019,北京同创永益科技发展有限公司
 * @Package: com.example.bootDemo.demo.controller
 * @ClassName: TestController_1
 * @Author: zhangxiao
 * @Description: redis测试控制器
 */
@Api(tags = {"boot管理"}, description = "eventChannelController")  //swagger Api标题配置
@RestController
public class RedisController {

    @Autowired
    private IRedisService redisService;

    //swagger参数说明
    @ApiOperation(value = "测试访问路径", httpMethod = "GET", notes = "测试访问路径")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", required = true, paramType = "String"),
            @ApiImplicitParam(name = "name", value = "id", required = true, paramType = "String"),
            @ApiImplicitParam(name = "age", value = "id", required = true, paramType = "String"),

    })
    @GetMapping("/hello")
    public String sayHello(){
        return "first StringBootDemoProject";
    }


    @ApiOperation(value = "读取redis缓存", httpMethod = "GET", notes = "读取redis缓存")
    @GetMapping("/read/id")
    public Object readCache(){
        return redisService.readCache("name");
    }

    @ApiOperation(value = "向redis中加入缓存数据", httpMethod = "GET", notes = "向redis中加入缓存数据")
    @GetMapping("/set")
    public void setCache(){
        redisService.setCache();
    }


}
