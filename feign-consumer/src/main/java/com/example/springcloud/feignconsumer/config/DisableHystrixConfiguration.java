package com.example.springcloud.feignconsumer.config;

import feign.Feign;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author kuanglifang
 * @date 2021/2/22 14:54
 *
 * 只针对某个服务客户端关闭 Hystrix支持
 * 在 feign接口中 注解@FeignClient 添加属性 configuration=DisableHystrixConfiguration.class
 */
@Configuration
public class DisableHystrixConfiguration {
    @Bean
    @Scope("prototype")
    public Feign.Builder feignBuilder() {
        return Feign.builder();
    }
}
