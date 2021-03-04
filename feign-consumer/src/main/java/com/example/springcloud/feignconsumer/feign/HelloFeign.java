package com.example.springcloud.feignconsumer.feign;

import com.example.springcloud.feignconsumer.feign.fallBack.HelloFeignFallBack;
import com.example.springcloud.feignconsumer.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author kuanglifang
 * @date 2021/2/22 10:15
 */
@FeignClient(value = "hello-service", fallback = HelloFeignFallBack.class)
public interface HelloFeign {
    @GetMapping("/hello")
    /**
     * 无参数调用
     * @return
     */
    String hello();

    /**
     * 在SpringMVC 程序中， 这些注解会根据参数名来作为默认值，但是在Feign 中绑定参数必须通过 value 属性来指明具体的参数名，
     * 不然会抛出口legalStateException 异常， value 属性不能为空
     * @param name
     * @return
     */
    @GetMapping("/hello1")
    String hello(@RequestParam("name") String name);

    @GetMapping("/hello2")
    User hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age);

    @PostMapping("/hello3")
    String hello(@RequestBody User user);
}
