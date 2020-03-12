package com.johar.javawebdemo.errorhandler;

import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * @ClassName: UserVO
 * @Description: TODO
 * @Author: Johar
 * @Date: 2020/3/1 17:10
 * @Version: 1.0
 */
@Data
@Builder
public class UserVO {
    @Length(min = 6, max = 128)
    private String name;
    @Length(max = 512)
    private String hobby;
    @Min(1)
    @Max(200)
    private int age;
}
