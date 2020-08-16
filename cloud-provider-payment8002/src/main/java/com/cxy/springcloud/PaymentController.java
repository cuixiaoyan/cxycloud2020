package com.cxy.springcloud;

import com.cxy.springcloud.entities.CommonResult;
import com.cxy.springcloud.entities.Payment;
import com.cxy.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @program: cxycloud2020
 * @description: 支付模块控制层
 * @author: cuixy
 * @create: 2020-08-08 14:20
 **/
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    /**
     * 远程调用需要 @RequestBody注解
     *
     * @param payment
     * @return
     */
    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("插入结果" + result);
        if (result > 0) {
            return new CommonResult(200, "插入数据成功,serverPort" + serverPort, result);
        } else {
            return new CommonResult(444, "插入数据库失败", null);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("获取结果" + payment);
        if (payment != null) {
            return new CommonResult(200, "获取数据成功,serverPort" + serverPort, payment);
        } else {
            return new CommonResult(444, "获取数据失败，ID是" + id, null);
        }
    }


}