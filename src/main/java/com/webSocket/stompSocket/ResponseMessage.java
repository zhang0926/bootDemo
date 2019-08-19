package com.webSocket.stompSocket;

/**
 * @Copyright (C), 2019,北京同创永益科技发展有限公司
 * @Package: com.example.demo.stomp
 * @ClassName: ResponseMessage
 * @Author: zhangxiao
 * @Description:  自定义消息返回类
 */
public class ResponseMessage{

    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public ResponseMessage setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public ResponseMessage setAge(Integer age) {
        this.age = age;
        return this;
    }
}
