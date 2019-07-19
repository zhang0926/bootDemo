package com.example.bootDemo.demo.service.impl;

import com.example.bootDemo.demo.entity.Demo;
import com.example.bootDemo.demo.mapper.IDemoMapper;
import com.example.bootDemo.demo.service.IDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Copyright (C), 2019,北京同创永益科技发展有限公司
 * @Package: com.example.bootDemo.demo.service.impl
 * @ClassName: DemoServiceImpl
 * @author: zhangxiao
 * @Description: ${description}
 */
@Service("/demoServiceimpl")
public class DemoServiceImpl implements IDemoService {

    @Autowired
    private IDemoMapper demoMapper;


    @Override
    public Integer update(String id) {
        return demoMapper.updateById(id);
    }

    @Override
    public Demo selectById(String id) {
        return demoMapper.selectById(id);
    }

    @Override
    public Integer deleteById(String id) {
        return demoMapper.deleteById(id);
    }
}
