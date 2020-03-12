package com.johar.javawebdemo.errorhandler;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: UserController
 * @Description: TODO
 * @Author: Johar
 * @Date: 2020/3/1 17:10
 * @Version: 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {
    private List<UserVO> userVOList = new ArrayList<>();

    @PostConstruct
    public void init(){
        userVOList.add(UserVO.builder().age(20).hobby("Reading").name("Johar").build());
        userVOList.add(UserVO.builder().age(20).hobby("Reading").name("Anna").build());
        userVOList.add(UserVO.builder().age(20).hobby("Reading").name("Lynn").build());
        userVOList.add(UserVO.builder().age(20).hobby("Reading").name("Jin").build());
        userVOList.add(UserVO.builder().age(20).hobby("Reading").name("Bob").build());
        userVOList.add(UserVO.builder().age(20).hobby("Reading").name("Juli").build());
    }

    @GetMapping("/findByName")
    public BaseResponse findByName(@RequestParam @NotEmpty String name){
        String str = name.toLowerCase();
        List<UserVO> users = new ArrayList<UserVO>();
        for (UserVO userVO : userVOList){
            if (userVO.getName().toLowerCase().contains(name)){
                users.add(userVO);
            }
        }

        return BaseResponse
                .builder()
                .data(users)
                .build();
    }
}
