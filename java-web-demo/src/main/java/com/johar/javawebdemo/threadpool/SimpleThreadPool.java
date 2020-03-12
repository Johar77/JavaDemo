package com.johar.javawebdemo.threadpool;

/**
 * @author Johar
 */
public interface SimpleThreadPool<Job extends Runnable> {
    /**
     * 执行一个Job
     * @param job
     */
    void execute(Job job);

    /**
     * 关闭线程次
     */
    void shutdown();

    /**
     * 增肌工作者线程
     * @param num
     */
    void addWorkers(int num);

    /**
     * 减少工作者线程
     * @param num
     */
    void removeWorkers(int num);

    /**
     * 获取正在等待执行的任务数量
     * @return
     */
    int getJobSize();
}
