package com.cxy.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @program: cxycloud2020
 * @description: RestTemplate配置类
 * @author: cuixy
 * @create: 2020-08-08 14:49
 **/
@Configuration
public class ApplicationContextConfig {

    @Bean
    //配置负载均衡，默认轮询。
    @LoadBalanced
    public RestTemplate getRestTemplate()
    {
        return new RestTemplate();
    }

}