package com.johar.javawebdemo.mutithread;

/**
 * @ClassName: AddTestThrea
 * @Description: TODO
 * @Author: Johar
 * @Date: 2019/12/28 17:11
 * @Version: 1.0
 */
public class AddTestThread  implements Runnable{
    private int num = 100;
    @Override
    public synchronized void run() {
        System.out.println(Thread.currentThread().getName() + "---->" + num--);
    }
}
