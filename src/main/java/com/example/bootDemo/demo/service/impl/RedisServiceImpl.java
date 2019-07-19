package com.example.bootDemo.demo.service.impl;

import com.example.bootDemo.demo.service.IRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @Copyright (C), 2019,北京同创永益科技发展有限公司
 * @Package: com.example.bootDemo.demo.service.impl
 * @ClassName: BootDemoServiceImpl
 * @author: zhangxiao
 * @Description: redis接口实现层
 */
@Service("bootDemoServiceImpl")
public class RedisServiceImpl implements IRedisService {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 读取缓存
     * @param
     * @return
     */
    @Override
    public Object  readCache(String key){
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * 写入缓存
     * @param
     * @return
     */
    @Override
    public void setCache(){
        redisTemplate.opsForValue().set("name", "zhangxiao");
    }

    /**
     * 更新缓存
     * @author zhangxiao
     * @param
     * @return
     */
    public void getAndSet(String key, String value){
        redisTemplate.opsForValue().getAndSet(key, value);
    }

    /**
     * 删除缓存
     * @author zhangxiao
     * @param
     * @return
     */
    public void delete(String key){
        redisTemplate.delete(key);
    }
}
