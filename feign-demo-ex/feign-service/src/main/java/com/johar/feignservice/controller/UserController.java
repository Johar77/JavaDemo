package com.johar.feignservice.controller;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.johar.commonlib.BaseResult;
import com.johar.commonlib.ResultCode;
import com.johar.commonlib.exception.BussinessException;
import com.johar.commonlib.exception.ServiceException;
import com.johar.feignapi.UserApi;
import com.johar.feignapi.dto.UserDto;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: UserController
 * @Description: TODO
 * @Author: Johar
 * @Date: 2020/3/15 22:38
 * @Version: 1.0
 */
@RestController
@RequestMapping("/v1/user")
@Validated
public class UserController implements UserApi {

    @PostMapping("/all")
    @Override
    public BaseResult findAllUser(){
        return BaseResult
                .success(UserDto
                        .builder()
                        .age(21)
                        .name("Johar")
                        .build());
    }

    @PostMapping("/error")
    public BaseResult findUserInternalError(){
        throw new ServiceException(ResultCode.UNKNOWN_ERROR);
    }

    @PostMapping("/exception")
    public BaseResult findUserException(){
        throw new BussinessException(ResultCode.FAIL, "获取用户失败");
    }
}
