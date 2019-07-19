package com.example.bootDemo.demo.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @Copyright (C), 2019,北京同创永益科技发展有限公司
 * @Package: com.example.bootDemo.demo.entity
 * @ClassName: Demo
 * @author: zhangxiao
 * @Description:
 */

@Data   //get、set方法
@NoArgsConstructor   //无参构造函数
@AllArgsConstructor  //全参构造函数
@Table(name = "demo")
public class Demo implements Serializable{

    //使用了lombok插件注解，实现Serializable序列化接口，使得可以存入内存或硬盘

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", length = 64)
    private String id;

    @Column(name = "name", length = 64)
    private String name;

    @Column(name = "age", length = 2)
    private Integer age;

}

