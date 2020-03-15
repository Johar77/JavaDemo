package com.johar.feignapi.dto;

import lombok.Builder;
import lombok.Data;

/**
 * @ClassName: UserDto
 * @Description: TODO
 * @Author: Johar
 * @Date: 2020/3/15 22:56
 * @Version: 1.0
 */
@Data
@Builder
public class UserDto {
    private String name;
    private int age;
}
