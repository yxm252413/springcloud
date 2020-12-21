package com.yxm.springcloud.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Classname PaymentService
 * @Description TODO
 * @Date 2020/12/21
 * @Created by yxm
 */
@Service
public class PaymentService {
    //    Hystrix用的是tomcat线程池

    /**
     * 正常访问,肯定是ok
     *
     * @param id
     * @return
     */
    public String paymentInfo_ok(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + "    paymentInfo_ok,id:" + id + "\t" + "哈哈O(∩_∩)O";
    }

    //超时模拟服务降级
    public String paymentInfo_timeout(Integer id) {
        int timeNum = 3;
        try {
            TimeUnit.SECONDS.sleep(timeNum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() + "    paymentInfo_timeout,id:" + id + "\t" + "哈哈O(∩_∩)O" + "   耗时(秒钟):" + timeNum;
    }
}
