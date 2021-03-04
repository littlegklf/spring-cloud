package com.example.springcloud.eurekaclient.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author kuanglifang
 * @date 2021/2/19 15:12
 */
@Data
@AllArgsConstructor
public class User {
    private String name;
    private Integer age;
}
