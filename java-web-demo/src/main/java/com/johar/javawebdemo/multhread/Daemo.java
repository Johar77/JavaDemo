package com.johar.javawebdemo.multhread;

/**
 * @ClassName: Daemo
 * @Description: TODO
 * @Author: Johar
 * @Date: 2020/2/25 08:52
 * @Version: 1.0
 */
public class Daemo {

    public static void main(String[] args){
        Thread thread = new Thread(new DaemoRunner(), "DaemoRunner");
        thread.setDaemon(true);
        thread.start();
    }

    public static class DaemoRunner implements Runnable{
        @Override
        public void run() {
            try{
                Thread.sleep(10*1000);
            } catch (Exception e){
                e.fillInStackTrace();
            } finally {
                System.out.println("DaemoThread finally run.");
            }
        }
    }
}
