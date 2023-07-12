package com.qp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.cloud.netflix.zuul.filters.discovery.PatternServiceRouteMapper;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }

    @ConfigurationProperties("zuul")
    public ZuulProperties zuulProperties(){
        return  new ZuulProperties();
    }

    @Bean
    public PatternServiceRouteMapper serviceRouteMapper(){
        return  new PatternServiceRouteMapper("(?<name>^.+)-(?<version>v.+$)","${name}");
    }
}
