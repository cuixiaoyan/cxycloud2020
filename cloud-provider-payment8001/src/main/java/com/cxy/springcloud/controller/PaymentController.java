package com.cxy.springcloud.controller;

import com.cxy.springcloud.entities.CommonResult;
import com.cxy.springcloud.entities.Payment;
import com.cxy.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

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

    @Resource
    //服务发现，是springframework的包。
    private DiscoveryClient discoveryClient;

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

    /**
     * 类似与关于我们，查看注册在eureka的服务信息 -> CLOUD-PAYMENT-SERVICE
     *
     * @return
     */
    @GetMapping("/payment/discovery")
    public Object discovery() {
        discoveryClient.getServices().forEach((element) -> log.info("******element" + element));
        discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE").forEach((instances) -> log.info(instances.getServiceId()
                + "\t" + instances.getHost() + "\t"
                + instances.getPort() + "\t" + instances.getUri()));

        return this.discoveryClient;
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB() {
        return serverPort;
    }

    /**
     * 增加openFeign超时方法
     */
    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout() {

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return serverPort;
    }

    /**
     * zipkin
     * @return
     */
    @GetMapping("/payment/zipkin")
    public String paymentZipkin()
    {
        return "hi ,i'am paymentzipkin server fall back，welcome to atguigu，O(∩_∩)O哈哈~";
    }


}