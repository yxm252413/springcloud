package com.yxm.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Classname GateWayConfig
 * @Description gateway路由配置两种方式：1.通过yml文件配置，2.通过java配置类配置。
 * @Date 2020/12/22
 * @Created by yxm
 */
//通过java配置类配置路由
@Configuration
public class GateWayConfig {
    /**
     * 功能描述：
     *
     * @param : 配置一个路由id为path_route_atyxm的路由，请求http://localhost:9527/guonei自动转发到http://news.baidu.com/guonei
     * @return :
     * @auther : yxm
     * @date : 2020/12/22
     */
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();//得到路由总线
        //path_route_atyxm路由id，匹配路径/guonei，自动转发到http://news.baidu.com/guonei
        routes.route("path_route_atyxm", r -> r.path("/guonei").uri("http://news.baidu.com/guonei")).build();
        return routes.build();
    }

    @Bean
    public RouteLocator customRouteLocator1(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();//得到路由总线
        routes.route("path_route_atyxm1", r -> r.path("/guoji").uri("http://news.baidu.com/guoji")).build();
        return routes.build();
    }
}
