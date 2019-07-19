package com.example.bootDemo.demo.service;

/**
 * @Copyright (C), 2019,北京同创永益科技发展有限公司
 * @Package: com.example.bootDemo.demo.service
 * @ClassName: BootDemoService
 * @author: zhangxiao
 * @Description: redis接口层
 */
public interface IRedisService {

    /**
     * 读取redis缓存
     * @author zhangxiao
     * @param key
     * @return 
     */
    Object readCache(String key);

    /**
     * 写入redis缓存
     * @author zhangxiao
     * @param
     * @return
     */
    void setCache();
}
