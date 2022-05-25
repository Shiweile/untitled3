package com.shiweile.config;


import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

//<context:component-scan base-package="com.shiweile"/>
@ComponentScan("com.shiweile")
@PropertySource("classpath:jdbc.properties")
public class SpringConfig {
    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;


    @Bean("dataSource")
    public DataSource getDataSource(){
//        <context:property-placeholder location="classpath:jdbc.properties"/>
//    <bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource">
//        <property name="driverClassName" value="${jdbc.driver}"></property>
//        <property name="Url" value="${jdbc.url}"></property>
//        <property name="username" value="${jdbc.username}"></property>
//        <property name="password" value="${jdbc.password}"></property>
//    </bean>
        DruidDataSource dataSource= new DruidDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

}
