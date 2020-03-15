package com.johar.feignapi;

import com.johar.commonlib.BaseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @ClassName: UserApi
 * @Description: TODO
 * @Author: Johar
 * @Date: 2020/3/15 22:19
 * @Version: 1.0
 */
@FeignClient(name = "UserApi", path = "/v1/user", url = "${feign-api-endpoint}")
public interface UserApi {
    @PostMapping("/all")
    BaseResult findAllUser();

}
