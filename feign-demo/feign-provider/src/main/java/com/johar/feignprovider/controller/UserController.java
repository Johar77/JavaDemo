package com.johar.feignprovider.controller;

import com.johar.feignapi.User;
import com.johar.feignapi.dto.BaseResponse;
import com.johar.feignapi.dto.UserDto;
import com.johar.feigncommon.ResultCode;
import com.johar.feigncommon.SubBussinessException;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName: UserController
 * @Description: TODO
 * @Author: Johar
 * @Date: 2020/3/15 14:00
 * @Version: 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController implements User {
    @GetMapping("/{userId}")
    @Override
    public BaseResponse<UserDto> findById(@PathVariable("userId") int userId) {
//        UserDto userDto = UserDto.builder().age(29).id(userId).name("johar").sex(1).build();
//        BaseResponse<UserDto> result = new BaseResponse<UserDto>();
//        result.setData(userDto);
//        return result;
        throw new SubBussinessException(ResultCode.ERROR_PARAM_NOT_VALID, "Test");
    }

    @PostMapping("/add")
    @Override
    public BaseResponse<UserDto> createUser(@RequestBody UserDto userDto) {
        userDto.setId(1);
        BaseResponse<UserDto> result = new BaseResponse<UserDto>();
        result.setData(userDto);
        return result;
    }
}
