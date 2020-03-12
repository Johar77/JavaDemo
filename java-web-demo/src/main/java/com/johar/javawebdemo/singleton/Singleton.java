package com.johar.javawebdemo.singleton;

/**
 * @ClassName: Singleton
 * @Description: TODO
 * @Author: Johar
 * @Date: 2020/1/1 17:59
 * @Version: 1.0
 */
public class Singleton {

    private Singleton(){
        System.out.println("singleton constructor");
    }

    private static class InnerSingleton{
        public static Singleton instance = new Singleton();
    }

    public static Singleton getInstance(){
        System.out.println("getInstance");
        return InnerSingleton.instance;
    }

    public static void main(String[] args){
        Singleton singleton = Singleton.getInstance();
        System.out.println(singleton.getClass().getName());
    }
}
