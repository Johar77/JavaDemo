package com.johar.javawebdemo.outofspace;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName: OutOfSpace
 * @Description: TODO
 * @Author: Johar
 * @Date: 2019/12/31 00:22
 * @Version: 1.0
 */
@Slf4j
@RestController
public class OutOfSpace {
    final static ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(100, 100, 1, TimeUnit.MINUTES,
            new LinkedBlockingQueue<>());// 创建线程池，通过线程池，保证创建的线程存活

    final static ThreadLocal<Byte[]> localVariable = new ThreadLocal<Byte[]>();// 声明本地变量

    @RequestMapping(value = "/test0")
    public String test0(HttpServletRequest request) {
//        poolExecutor.execute(new Runnable() {
//            @Override
//            public void run() {
//                Byte[] c = new Byte[4096*1024];
//                localVariable.set(c);// 为线程添加变量
//            }
//        });

        Byte[] c = new Byte[4096*1024];
        localVariable.set(c);// 为线程添加变量
        //localVariable.remove();
        log.info(Thread.currentThread().getName() + ": " + "test0");
        return "success";
    }

    @RequestMapping(value = "/test1")
    public String test1(HttpServletRequest request) {
        List<Byte[]> temp1 = new ArrayList<Byte[]>();

        Byte[] b = new Byte[1024*20];
        temp1.add(b);// 添加局部变量
        log.info(Thread.currentThread().getName() + ": " + "test1");
        return "success";
    }
}
