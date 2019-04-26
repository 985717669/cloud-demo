package com.fengjf.demo.gatewaydemo.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * Author fengjf
 * Desc
 */
@Component
public class CustomFilter implements GlobalFilter, Ordered {

    private static final Logger log = LoggerFactory.getLogger(GatewayFilter.class);

    @Override
    public int getOrder() {
        return 0;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("进入过滤器");
        ServerHttpRequest request = exchange.getRequest();
        String path = request.getPath().pathWithinApplication().value();
        String method = request.getMethodValue();
        log.info("请求路径 {}， 请求方法{}", path, method);
        ServerHttpResponse response = exchange.getResponse();
        response.setStatusCode(HttpStatus.OK);
        response.getHeaders().add("Content-Type", "text/plain;charset=UTF-8");
        response.getHeaders().add("Access-Control-Allow-Origin", "*");
//        if ("GET".equals(method)) {
//            response.setStatusCode(HttpStatus.FORBIDDEN);
////            return response.setComplete();
//            Publisher publisher = new Publisher() {
//                @Override
//                public void subscribe(Subscriber s) {
//
//                    response.setStatusCode(HttpStatus.FORBIDDEN);
//                }
//            };
//            return chain.filter(exchange).and(publisher);
//        }
        return chain.filter(exchange);
    }
}
