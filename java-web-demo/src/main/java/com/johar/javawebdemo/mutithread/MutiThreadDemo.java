package com.johar.javawebdemo.mutithread;


import org.springframework.util.StringUtils;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.atomic.LongAdder;

/**
 * @ClassName: MutiThreadDemo
 * @Description: TODO
 * @Author: Johar
 * @Date: 2019/12/28 16:47
 * @Version: 1.0
 */
public class MutiThreadDemo {

    public static void main(String[] args) throws Exception{
//        Thread[] threads = new Thread[10];
//        Runnable t = new AutoIntegerThread();
//        for (int i = 0; i < 10; i++){
//            threads[i] = new Thread(t, "thread" + i);
//        }
//
//        for (Thread thread : threads) {
//            thread.start();
//        }

        LongAdder longAdder = new LongAdder();
        longAdder.add(2);
        System.out.println(longAdder.intValue());
        longAdder.increment();
        System.out.println(longAdder.intValue());
        longAdder.decrement();
        System.out.println(longAdder.intValue());
    }
}
