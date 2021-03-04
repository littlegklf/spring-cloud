package com.example.springcloud.hystrix.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author kuanglifang
 * @date 2021/2/19 15:12
 */
@Data
@AllArgsConstructor
public class User {
    private Long id;
    private String userName;
}
