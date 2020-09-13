package com.cxy.springcloud.service;

import com.cxy.springcloud.domain.Order;

/**
 * @program: cxycloud2020
 * @description: 订单
 * @author: cuixy
 * @create: 2020-09-13 10:56
 **/
public interface OrderService {
    void create(Order order);
}