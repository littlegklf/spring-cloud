package com.example.springcloud.feignconsumer.feign.fallBack;

import com.example.springcloud.feignconsumer.feign.HelloFeign;
import com.example.springcloud.feignconsumer.entity.User;

/**
 * @author kuanglifang
 * @date 2021/2/22 15:08
 */
public class HelloFeignFallBack implements HelloFeign {
    @Override
    public String hello() {
        return "error";
    }

    @Override
    public String hello(String name) {
        return "error";
    }

    @Override
    public User hello(String name, Integer age) {
        return new User("未知", 0);
    }

    @Override
    public String hello(User user) {
        return "error";
    }
}
