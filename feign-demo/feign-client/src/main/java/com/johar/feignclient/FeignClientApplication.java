package com.johar.feignclient;

import com.johar.feignapi.User;
import com.johar.feignapi.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.johar.feignapi")
public class FeignClientApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(FeignClientApplication.class, args);
    }

    @Autowired
    private User user;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(user.findById(1));
        System.out.println(user.createUser(UserDto.builder().sex(2).name("Anna").age(28).build()));
    }
}
