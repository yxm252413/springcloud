package com.yxm.springcloud.controller;

import com.yxm.springcloud.entities.CommonResult;
import com.yxm.springcloud.entities.Payment;
import com.yxm.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.xml.ws.Service;
import java.util.List;

/**
 * @Classname PaymentController
 * @Description TODO
 * @Date 2020/12/14
 * @Created by yxm
 */
@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;
    @Resource
    private PaymentService paymentService;
    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("*******插入结果：" + result);
        if (result > 0) {
            return new CommonResult(200, "操作成功,serverPort:" + serverPort, result);
        } else {
            return new CommonResult(444, "操作失败", null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult create(@PathVariable("id") Long id) {
        Payment result = paymentService.getPaymentById(id);
        log.info("*******插入结果----------------：" + result);
        if (result != null) {
            return new CommonResult(200, "查询成功,serverPort:" + serverPort, result);
        } else {
            return new CommonResult(444, "没有找到对应的记录，查询id:" + id, null);
        }
    }

    @GetMapping(value = "/payment/discovery")
    public Object discover() {
        //获取eureka中的服务
        List<String> services = discoveryClient.getServices();
        for (String elem : services) {
            //eureka中的服务
            log.info("**************elem:" + elem);
        }
        //获取CLOUD-PAYMENT-SERVICE服务中的实例
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance si : instances) {
            log.info(si.getServiceId() + "\t" + si.getHost() + "\t" + si.getPort() + "\t" + si.getUri());
        }
        return this.discoveryClient;
    }
}
