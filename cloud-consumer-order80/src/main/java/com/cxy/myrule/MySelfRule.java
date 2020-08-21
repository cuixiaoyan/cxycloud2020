package com.cxy.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: cxycloud2020
 * @description: MySelfRule不能和主启动类同级别。
 * @author: cuixy
 * @create: 2020-08-21 22:10
 **/
@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule()
    {
        return new RandomRule();//定义为随机
    }

}