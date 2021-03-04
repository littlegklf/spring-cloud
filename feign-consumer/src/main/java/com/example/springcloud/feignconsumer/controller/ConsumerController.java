package com.example.springcloud.feignconsumer.controller;

import com.example.helloserviceapi.dto.User;
import com.example.springcloud.feignconsumer.feign.HelloFeign;
import com.example.springcloud.feignconsumer.feign.RefactorHelloFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kuanglifang
 * @date 2021/2/22 10:14
 */
@RestController
public class ConsumerController {
    @Autowired
    HelloFeign helloFeign;

    @Autowired
    RefactorHelloFeign refactorHelloFeign;

    @GetMapping("/feign-consumer")
    public String helloConsumer() {
        return helloFeign.hello();
    }

    @GetMapping("/feign-consumer2")
    public String helloConsumer2() {
        StringBuilder sb = new StringBuilder();
        sb.append(helloFeign.hello()).append("\n");
        sb.append(helloFeign.hello("DIDI")).append("\n");
        sb.append(helloFeign.hello("DIDI", 30)).append("\n");
        //sb.append(helloService.hello(new User("DIDI", 30))).append("\\n");
        return sb.toString();
    }

    @GetMapping("/feign-consumer3")
    public String helloConsumer3() {
        StringBuilder sb = new StringBuilder();
        sb.append(refactorHelloFeign.hello("MIMI")).append("\n");
        sb.append(refactorHelloFeign.hello("MIMI", 30)).append("\n");
        sb.append(refactorHelloFeign.hello(new User("MIMI", 30))).append("\n");
        return sb.toString();
    }
}
