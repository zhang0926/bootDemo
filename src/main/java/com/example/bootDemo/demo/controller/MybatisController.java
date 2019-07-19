package com.example.bootDemo.demo.controller;

import com.example.bootDemo.demo.service.IDemoService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Copyright (C), 2019,北京同创永益科技发展有限公司
 * @Package: com.example.bootDemo.demo.controller
 * @ClassName: MybatisController
 * @author: zhangxiao
 * @Description: 测试整合mybatis控制器
 */
@Api(tags = {"mybatis测试控制器"}, description = "MybatisController")
@RestController
@RequestMapping("/mybatis")
public class MybatisController {

    @Autowired
    private IDemoService demoService;

    @GetMapping("/select/id")
    public Object selectById(String id){
        return demoService.selectById(id);
    }

    @GetMapping("/update/id")
    public Object updateById(String id){
        return demoService.update(id);
    }
}
