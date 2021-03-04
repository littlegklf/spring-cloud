package com.example.helloserviceapi.service;

import com.example.helloserviceapi.dto.User;
import org.springframework.web.bind.annotation.*;

/**
 * @author kuanglifang
 * @date 2021/2/22 11:46
 */
@RequestMapping("/refactor")
public interface HelloService {
    @GetMapping("/hello4")
    String hello(@RequestParam("name") String name);

    @GetMapping("/hello5")
    User hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age);

    @PostMapping("/hello6")
    String hello(@RequestBody User user);
}
