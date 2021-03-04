package com.example.springcloud.ribbonconsumer.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author kuanglifang
 * @date 2021/2/19 11:47
 */
@Service
public class HelloService {
    @Autowired
    RestTemplate restTemplate;

    /**
     *
     * @return
     * 只是同步执行的实现
     *
     * 我们需要将具体的Hystrix 命令与 fallback 实现函数定义在同一个类中， 并且 fallbackMethod 的值必须与实现fallback 方法的名字相同
     */
    @HystrixCommand(fallbackMethod = "helloFallback")
    public String helloService() {
        return restTemplate.getForEntity("http://EUREKA-CLIENT/hello", String.class).getBody();
    }

    /**
     *
     * @param id
     * @return
     *
     * 异步执行的实现
     */
    @HystrixCommand
    public Future<User> getUserByIdAsync(String id) {
        return new AsyncResult<User>() {
            @Override
            public User invoke() {
                return restTemplate.getForObject("http://EUREKA-CLIENT/users/{1}", User.class, id);
            }
        };
    }

    public String helloFallback() {
        return "error";
    }
}
