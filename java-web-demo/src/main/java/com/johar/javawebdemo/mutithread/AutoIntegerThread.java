package com.johar.javawebdemo.mutithread;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName: AutoIntegerThread
 * @Description: TODO
 * @Author: Johar
 * @Date: 2019/12/28 17:23
 * @Version: 1.0
 */
public class AutoIntegerThread implements Runnable {
    private AtomicInteger integer = new AtomicInteger(100);

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "---->" + integer.getAndDecrement());
    }
}
