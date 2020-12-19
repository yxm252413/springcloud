package com.yxm.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Classname MyLB
 * @Description 负载均衡实现类
 * @Date 2020/12/20
 * @Created by yxm
 */
@Component//让容器扫描到这个类
public class MyLB implements LoadBalancer {
    //声明一个原子的自增变量
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    //坐标
    //参考RoundRobinRule 类的源码实现 自定义选择规则
    private final int getAndIncrement() {
        int current;
        int next;
        do {
            current = this.atomicInteger.get();
            //Integer 最大值2147483647
            next = current >= 2147483647 ? 0 : current + 1;
        } while (!this.atomicInteger.compareAndSet(current, next)); //第一个参数是期望值，第二个参数是修改值
        System.out.println("****************第几次访问，次数next:" + next);
        return next;
    }

    //负载均衡算法: rest接口第几次请求数%服务器集群总数量=实际调用服务器位置下标.每次服务重启动后rest接口计数从1开始。
    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {//得到服务中心的服务的列表

        int index = getAndIncrement() % serviceInstances.size();//得到服务的下标
        return serviceInstances.get(index);
    }
}
