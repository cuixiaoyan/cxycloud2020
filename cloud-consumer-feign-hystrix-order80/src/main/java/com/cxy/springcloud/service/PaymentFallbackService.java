package com.cxy.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @program: cxycloud2020
 * @description: 接口级别降级
 * @author: cuixy
 * @create: 2020-08-28 20:14
 **/
@Component
public class PaymentFallbackService implements PaymentHystrixService {

    @Override
    public String paymentInfo_OK(Integer id) {
        return "-----PaymentFallbackService fall back-paymentInfo_OK ,o(╥﹏╥)o";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "-----PaymentFallbackService fall back-paymentInfo_TimeOut ,o(╥﹏╥)o";
    }
}