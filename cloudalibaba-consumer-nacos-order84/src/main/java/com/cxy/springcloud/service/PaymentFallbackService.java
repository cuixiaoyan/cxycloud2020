package com.cxy.springcloud.service;

import com.cxy.springcloud.entities.CommonResult;
import com.cxy.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * @program: cxycloud2020
 * @description:
 * @author: cuixy
 * @create: 2020-09-12 17:59
 **/
@Component
public class PaymentFallbackService implements PaymentService {
    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(44444, "服务降级返回,---PaymentFallbackService", new Payment(id, "errorSerial"));
    }
}