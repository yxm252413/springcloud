package com.yxm.springcloud.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 * @Classname MyLogGateWayFilter
 * @Description 全局过滤器
 * @Date 2020/12/22
 * @Created by yxm
 */
@Component//可以被springboot扫描到
@Slf4j
public class MyLogGateWayFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange serverWebExchange, GatewayFilterChain gatewayFilterChain) {
        log.info("come in MyLogGateWayFilter:" + new Date());
        String uname = serverWebExchange.getRequest().getQueryParams().getFirst("uname");//获取请求参数
        if (uname == null) {
            log.info("用户名为空，非法用户，/(ㄒoㄒ)/~~");
            serverWebExchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);//如果请求参数为空，设置相应状态
            return serverWebExchange.getResponse().setComplete();//返回相应信息
        }
        return gatewayFilterChain.filter(serverWebExchange);//如果参数正确，放行
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
