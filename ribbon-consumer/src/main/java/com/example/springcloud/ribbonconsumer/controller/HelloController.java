package com.example.springcloud.ribbonconsumer.controller;

import com.example.springcloud.ribbonconsumer.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kuanglifang
 * @date 2021/2/3 17:51
 */
@RestController
public class HelloController {
    @Autowired
    HelloService helloService;
    @GetMapping("/hi")
    public String hello() {
        return helloService.helloService();
    }
}
