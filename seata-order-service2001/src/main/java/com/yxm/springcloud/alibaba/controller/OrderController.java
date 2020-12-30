package com.yxm.springcloud.alibaba.controller;

import com.yxm.springcloud.alibaba.domain.CommonResult;
import com.yxm.springcloud.alibaba.domain.Order;
import com.yxm.springcloud.alibaba.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Classname OrderController
 * @Description TODO
 * @Date 2020/12/30
 * @Created by yxm
 */
@RestController
public class OrderController {
    @Resource
    private OrderService orderService;

    @GetMapping("/order/create")
    public CommonResult create(Order order) {
        orderService.create(order);
        return new CommonResult(200, "订单成功");
    }
}
