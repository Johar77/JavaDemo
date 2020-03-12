package com.johar.javawebdemo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName: FairAndUnfairTest
 * @Description: TODO
 * @Author: Johar
 * @Date: 2020/3/8 22:44
 * @Version: 1.0
 */
public class FairAndUnfairTest {
    private static class RentrantLock2 extends ReentrantLock{
        public RentrantLock2(boolean fair){
            super(fair);
        }

        public Collection<Thread> getQueuedThreads(){
            List<Thread> arrayList = new ArrayList<>(super.getQueuedThreads());
            Collections.reverse(arrayList);

            return arrayList;
        }
    }

    private static class Job extends Thread{
        private RentrantLock2 lock;

        public Job(RentrantLock2 lock){
            this.lock = lock;
        }

        @Override
        public void run(){
            lock.lock();
            try {
                StringBuilder ids = new StringBuilder();
                lock.getQueuedThreads().forEach((t) -> {
                    ids.append(t.getId()).append(',');
                });
                System.out.println("Lock by [" + Thread.currentThread().getId() + "],Waiting by [" + ids.toString() + "]");
            } finally {
                lock.unlock();
            }
            StringBuilder ids = new StringBuilder();
            lock.getQueuedThreads().forEach((t) -> {
                ids.append(t.getId()).append(',');
            });
            System.out.println("Lock by [" + Thread.currentThread().getId() + "],Waiting by [" + ids.toString() + "]");
        }
    }

    private static  RentrantLock2 fairLock = new RentrantLock2(true);
    private static RentrantLock2 unfairLock = new RentrantLock2(false);

    @Test
    public void fair() throws Exception{
        testLock(fairLock);
    }

    @Test
    public void unfair() throws Exception{
        testLock(unfairLock);
    }

    private void testLock(RentrantLock2 lock2) throws Exception{
        ArrayList<Job> jobs = new ArrayList<>();
        for (int i = 0; i < 5; i++){
            Job job = new Job(lock2);
            jobs.add(job);
            job.start();
        }

        jobs.forEach((t) ->{
            try {
                t.join();
            } catch (Exception e) {

            }
        });
    }
}
