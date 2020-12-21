package com.yxm.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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
    // @HystrixCommand服务降级注解，fallbackMethod兜底方法，paymentInfo_timeoutHandler对应下面的方法名，如果该方法超时或者报错，会进入兜底方法paymentInfo_timeoutHandler，
    @HystrixCommand(fallbackMethod = "paymentInfo_timeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")//峰值时间设置3秒钟
    })
    public String paymentInfo_timeout(Integer id) {
        int age = 10 / 0;
        return "线程池：" + Thread.currentThread().getName() + "    paymentInfo_timeout,id:" + id + "\t" + "呜呜/(ㄒoㄒ)/~~";
      /*  int timeNum = 15;//业务处理逻辑模拟，设置5秒钟
        try {
            TimeUnit.SECONDS.sleep(timeNum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() + "    paymentInfo_timeout,id:" + id + "\t" + "呜呜/(ㄒoㄒ)/~~" + "   耗时(秒钟):" + timeNum;
    */
    }

    //兜底方法
    //paymentInfo_timeout超时或者报错，将走paymentInfo_timeoutHandler兜底方法
    public String paymentInfo_timeoutHandler(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + "    业务繁忙或程序出错,请稍后再试，id:" + id + "\t" + "呜呜/(ㄒoㄒ)/~~";
    }

}
