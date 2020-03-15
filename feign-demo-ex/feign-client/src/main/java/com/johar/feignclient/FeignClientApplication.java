package com.johar.feignclient;

import com.johar.feignapi.UserApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = {"com.johar"})
public class FeignClientApplication implements CommandLineRunner {

    @Autowired
    private UserApi userApi;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(userApi.findAllUser());
    }

    public static void main(String[] args) {
        SpringApplication.run(FeignClientApplication.class, args);
    }

}
