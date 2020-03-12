package com.johar.javawebdemo.multhread;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * @ClassName: MultiThread
 * @Description: TODO
 * @Author: Johar
 * @Date: 2020/2/23 23:15
 * @Version: 1.0
 */
public class MultiThread {

    public static void main(String[] args){
        ThreadMXBean mxBean = ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos = mxBean.dumpAllThreads(false,false);
        for (ThreadInfo threadInfo : threadInfos){
            System.out.println("[" + threadInfo.getThreadId() + "] " + threadInfo.getThreadName());
        }
    }
}
