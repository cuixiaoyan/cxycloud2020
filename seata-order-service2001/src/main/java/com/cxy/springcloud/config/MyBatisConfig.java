package com.cxy.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @program: cxycloud2020
 * @description:
 * @author: cuixy
 * @create: 2020-09-13 10:52
 **/
@Configuration
@MapperScan({"com.cxy.springcloud.dao"})
public class MyBatisConfig {
}