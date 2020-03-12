package com.johar.feignapi;

import com.johar.feignapi.dto.BaseResponse;
import com.johar.feignapi.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @ClassName: User
 * @Description: TODO
 * @Author: Johar
 * @Date: 2020/3/11 23:11
 * @Version: 1.0
 */
@FeignClient(value = "com.johar.feign-test", path = "/user", url="${account-service-endpoint}")
public interface User {
    @GetMapping("/{userId}")
    public BaseResponse<UserDto> findById(@PathVariable("userId") int userId);

    @PostMapping("/add")
    public BaseResponse<UserDto> createUser(@RequestBody UserDto userDto);
}
