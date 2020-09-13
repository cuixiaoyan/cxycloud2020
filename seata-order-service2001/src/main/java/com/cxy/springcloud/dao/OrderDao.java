package com.cxy.springcloud.dao;

import com.cxy.springcloud.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @program: cxycloud2020
 * @description:
 * @author: cuixy
 * @create: 2020-09-13 10:54
 **/
@Mapper
public interface OrderDao {
    //1 新建订单
    void create(Order order);

    //2 修改订单状态，从零改为1
    void update(@Param("userId") Long userId, @Param("status") Integer status);
}