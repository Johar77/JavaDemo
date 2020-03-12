package com.johar.javawebdemo.lockdemo;


import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName: ReentrantLockExample
 * @Description: TODO
 * @Author: Johar
 * @Date: 2020/2/22 22:49
 * @Version: 1.0
 */
public class ReentrantLockExample {
    int a = 0;
    ReentrantLock lock = new ReentrantLock();

    public void writer(){
        lock.lock();
        try{
            a++;
        }finally {
            lock.unlock();
        }
    }

    public void reader(){
        lock.lock();
        try{
            a++;
        }finally {
            lock.unlock();
        }
    }

}
