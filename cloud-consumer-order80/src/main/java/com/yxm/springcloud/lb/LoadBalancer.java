package com.yxm.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @Classname LoadBalancer
 * @Description 自定义负载均衡
 * @Date 2020/12/20
 * @Created by yxm
 */
public interface LoadBalancer {
    //收集服务器总共有多少台能够提供服务的机器，并放到list里面
    //instances方法返回当前服务的实例ServiceInstance，serviceInstances参数是服务实例的集合
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
