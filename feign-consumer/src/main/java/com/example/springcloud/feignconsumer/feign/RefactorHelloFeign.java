package com.example.springcloud.feignconsumer.feign;

import com.example.helloserviceapi.service.HelloService;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author kuanglifang
 * @date 2021/2/22 14:04
 */
@FeignClient(value = "hello-service", contextId = "2")
public interface RefactorHelloFeign extends HelloService {
}
