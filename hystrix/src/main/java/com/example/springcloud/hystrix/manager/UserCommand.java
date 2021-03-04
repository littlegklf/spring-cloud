package com.example.springcloud.hystrix.manager;

import com.example.springcloud.hystrix.entity.User;
import com.netflix.hystrix.HystrixCommand;
import org.springframework.web.client.RestTemplate;

/**
 * @author kuanglifang
 * @date 2021/2/19 15:24
 * UserCommand 既可以实现请求的同步执行也可以实现异步执行
 * 同步执行：User user = new UserCommand(restTemplate, 1L).execute();
 * 异步执行：Future<User> futureUser = new UserCommand (restTemplate,lL) .queue();异步执行的时候，可以通过对返回的 futureUser 调用get方
 * 法来获取结果。
 *
 * 另外可以通过@HystrixCommand 注解来更为优雅地实现 Hystrix 命令的定义 详细见 ribbon-consumer 项目的 HelloService
 */
public class UserCommand extends HystrixCommand<User> {

    private RestTemplate restTemplate;
    private Long id;

    protected UserCommand(Setter setter, RestTemplate restTemplate, Long id) {
        super(setter);
        this.restTemplate = restTemplate;
        this.id = id;
    }

    @Override
    protected User run() {
        return restTemplate.getForObject("http://EUREKA-CIENT/users/{1}", User.class, id);
    }
}
