package com.johar.feignapi.dto;

import lombok.*;

/**
 * @ClassName: UserDto
 * @Description: TODO
 * @Author: Johar
 * @Date: 2020/3/11 23:18
 * @Version: 1.0
 */
@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private int id;
    private String name;
    private int sex;
    private int age;
}
