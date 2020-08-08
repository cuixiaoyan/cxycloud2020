package com.cxy.springcloud.service.impl;

import com.cxy.springcloud.dao.PaymentDao;
import com.cxy.springcloud.entities.Payment;
import com.cxy.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program: cxycloud2020
 * @description: 支付模块实现类。
 * @author: cuixy
 * @create: 2020-08-08 14:17
 **/
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;


    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}