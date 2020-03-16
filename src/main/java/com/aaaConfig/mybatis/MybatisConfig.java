package com.aaaConfig.mybatis;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @Copyright (C), 2019,北京同创永益科技发展有限公司
 * @Package: com.example.bootDemo.config.mybatis
 * @ClassName: MybatisConfig
 * @author: zhangxiao
 * @Description: mybatis配置类
 */
@Configuration
public class MybatisConfig {

    /**
     * mybatis扫描实体类
     */
    private static final String TYPE_ALIASES_PACKAGE = "com.example.bootDemo.*.entity.**";

    /**
     * mybatis扫描当前服务数据接口mapper文件
     */
    private static final String MYBATIS_CURRENT_MAPPER_PACKAGE = "com.example.bootDemo.*.mapper.**";

    /**
     * mybatis扫描当前服务数据接口mapper文件对应的xml SQL处理文件
     */
    private static final String MYBATIS_CURRENT_MAPPER_XML = "classpath*:mapper/**/*.xml";

    @Bean
    public SqlSessionFactory sqlSessionFactoryBean(DataSource dataSource) throws  Exception{
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setTypeAliasesPackage(TYPE_ALIASES_PACKAGE);

        //添加xml目录
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        factoryBean.setMapperLocations(resolver.getResources(MYBATIS_CURRENT_MAPPER_XML));
        return factoryBean.getObject();
    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactoryBean");
        mapperScannerConfigurer.setBasePackage(MYBATIS_CURRENT_MAPPER_PACKAGE);
        Properties properties = new Properties();
        properties.setProperty("notEmpty","false");
        properties.setProperty("IDENTITY","SELECT REPLACE(UUID(),''-'','''')");
        properties.setProperty("ORDER","BEFORE");
//        mapperScannerConfigurer.setProperties(properties);
        return mapperScannerConfigurer;
    }

}
