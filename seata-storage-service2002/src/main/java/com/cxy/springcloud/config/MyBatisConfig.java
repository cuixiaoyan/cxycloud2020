package com.cxy.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @auther cxy
 * @create 2019-12-11 16:57
 */
@Configuration
@MapperScan({"com.cxy.springcloud.dao"})
public class MyBatisConfig {
}
