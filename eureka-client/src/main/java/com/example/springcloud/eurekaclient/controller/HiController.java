package com.example.springcloud.eurekaclient.controller;

import com.example.springcloud.eurekaclient.entity.User;
import org.springframework.web.bind.annotation.*;

/**
 * @author kuanglifang
 * @date 2021/2/3 11:28
 */
@RestController
public class HiController {

    @GetMapping("/hello")
    public String hello() {
        return "hello world";
    }

    @GetMapping("/hello1")
    public String hello(@RequestParam String name) {
        return "hello " + name;
    }

    @GetMapping("/hello2")
    public User hello(@RequestHeader String name, @RequestHeader Integer age) {
        return new User(name, age);
    }

    @PostMapping("/hello3")
    public String hello(@RequestBody User user) {
        return "hello " + user.getName() + ", " + user.getAge();
    }
}
