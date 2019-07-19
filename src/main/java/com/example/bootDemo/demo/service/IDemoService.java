package com.example.bootDemo.demo.service;

import com.example.bootDemo.demo.entity.Demo;

import java.util.Map;

/**
 * @Copyright (C), 2019,北京同创永益科技发展有限公司
 * @Package: com.example.bootDemo.demo.service
 * @ClassName: IDemoService
 * @author: zhangxiao
 * @Description: ${description}
 */
public interface IDemoService {

    Integer update(String id);

    Demo selectById(String id);

    Integer deleteById(String id);
}
