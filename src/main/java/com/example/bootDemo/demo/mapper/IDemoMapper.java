package com.example.bootDemo.demo.mapper;

import com.example.bootDemo.demo.entity.Demo;
import org.springframework.stereotype.Repository;

/**
 * @Copyright (C), 2019,北京同创永益科技发展有限公司
 * @Package: com.example.bootDemo.demo.mapper
 * @ClassName: IDemoMapper
 * @author: zhangxiao
 * @Description: ${description}
 */
@Repository("demoMapper")
public interface IDemoMapper {

    Demo selectById(String id);

    Integer deleteById(String id);

    Integer updateById(String id);
}
