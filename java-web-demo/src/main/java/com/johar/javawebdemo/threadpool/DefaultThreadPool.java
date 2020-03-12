package com.johar.javawebdemo.threadpool;


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @ClassName: DefaultThreadPool
 * @Description: TODO
 * @Author: Johar
 * @Date: 2020/2/29 10:32
 * @Version: 1.0
 */
public class DefaultThreadPool<Job extends Runnable> implements SimpleThreadPool<Job> {
    private static final int MAX_WORKER_NUMBERS = 10;
    private static final int DEFAULT_WORKER_NUMBERS = 5;
    private static final int MIN_WORKER_NUMBERS = 1;

    private final LinkedList<Job> jobs = new LinkedList<>();
    private final List<Worker> workers = Collections.synchronizedList(new ArrayList<>());
    private int workerNum = DEFAULT_WORKER_NUMBERS;
    private AtomicLong threadNum = new AtomicLong();

    private DefaultThreadPool(){
        initialzeWorkers(DEFAULT_WORKER_NUMBERS);
    }

    public DefaultThreadPool(int workerNum){
        this.workerNum = workerNum > MAX_WORKER_NUMBERS ? MAX_WORKER_NUMBERS : workerNum < MIN_WORKER_NUMBERS ? MIN_WORKER_NUMBERS : workerNum;
        initialzeWorkers(this.workerNum);
    }

    private void initialzeWorkers(int num){
        for (int i = 0; i < num; i++){
            Worker worker = new Worker();
            workers.add(worker);
            Thread thread = new Thread(worker, "ThreadPool-Worker-" + threadNum.incrementAndGet());
            thread.start();
        }
    }


    @Override
    public void execute(Job job) {
        if (job != null){
            synchronized (jobs){
                jobs.add(job);
                jobs.notify();
            }
        }
    }

    @Override
    public void shutdown() {
        for (Worker worker : workers){
            worker.shutdown();
        }
    }

    @Override
    public void addWorkers(int num) {
        if (num <= 0){
            throw new IllegalArgumentException("参数必须大于0");
        }
        synchronized (jobs){
            if (num + this.workerNum > MAX_WORKER_NUMBERS){
                num = MAX_WORKER_NUMBERS - this.workerNum;
            }
            initialzeWorkers(num);
            this.workerNum += num;
        }
    }


    @Override
    public void removeWorkers(int num) {
        if (num <= 0){
            throw new IllegalArgumentException("参数必须大于0");
        }

        if (num > this.workerNum){
            throw new IllegalArgumentException("超出目前工作线程数范围");
        }

        synchronized (jobs){
            for (int i = 0; i < num; i++){
                Worker worker = workers.get(i);
                if (workers.remove(worker)){
                    worker.shutdown();
                }
            }
        }
        this.workerNum -= num;
    }


    @Override
    public int getJobSize() {
        return jobs.size();
    }

    class Worker implements Runnable{
        private volatile boolean running = true;

        @Override
        public void run() {
            while (running){
                Job job = null;
                synchronized (jobs){
                    while (jobs.isEmpty()){
                        try{
                            jobs.wait();
                        } catch (InterruptedException e){
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }
                    job = jobs.removeFirst();
                }
                if (job != null){
                    try{
                        job.run();
                    } catch (Exception e){
                        e.fillInStackTrace();
                    }
                }
            }
        }

        public void shutdown(){
            running = false;
        }
    }
}
