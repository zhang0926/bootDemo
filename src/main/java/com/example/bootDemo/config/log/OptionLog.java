package com.example.bootDemo.config.log;

import java.lang.annotation.*;

/**
 * @Copyright (C), 2019,北京同创永益科技发展有限公司
 * @Package: com.example.bootDemo.config.log
 * @ClassName: OptionLog
 * @author: zhangxiao
 * @Description: 自定日志注解
 */

@Target({ElementType.PARAMETER, ElementType.METHOD}) //注解作用目标
@Retention(RetentionPolicy.RUNTIME)  //注解的保留位置
@Documented //该注解将被包含在javadoc中
public @interface OptionLog {

    /**
     *  定义注解的属性
     */

    /**
     * 要执行的操作类型（比如：add操作）
     */
    String type() default "";

    /**
     * 业务的日志分类（比如:登录日志，脚本日志，流程日志，操作日志）
     *
     * @return
     */
    String businessType() default "";

    /**
     * 要执行的具体操作类型（比如：添加用户）
     */
    String description() default "";
}
