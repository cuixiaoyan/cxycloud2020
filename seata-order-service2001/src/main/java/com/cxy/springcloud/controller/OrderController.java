package com.cxy.springcloud.controller;

import com.cxy.springcloud.domain.CommonResult;
import com.cxy.springcloud.domain.Order;
import com.cxy.springcloud.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program: cxycloud2020
 * @description:
 * @author: cuixy
 * @create: 2020-09-13 10:59
 **/
@RestController
public class OrderController {
    @Resource
    private OrderService orderService;


    @GetMapping("/order/create")
    public CommonResult create(Order order) {
        orderService.create(order);
        return new CommonResult(200, "订单创建成功");
    }
}