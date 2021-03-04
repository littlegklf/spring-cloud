package com.example.springcloud.feignconsumer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author kuanglifang
 * @date 2021/2/22 11:02
 */
@Data
@AllArgsConstructor
public class User {
    private String name;
    private Integer age;

    @Override
    public String toString() {
        return "name=" + name + ", age=" + age;
    }
}
