package com.johar.javawebdemo.classloaderdemo;

/**
 * @ClassName: CustomClassLoader
 * @Description: TODO
 * @Author: Johar
 * @Date: 2019/12/26 22:45
 * @Version: 1.0
 */
public class CustomClassLoader {

    public CustomClassLoader(){

        System.out.println(this.getClass().getClassLoader().getResource("").toString());
    }

    public static void main(String[] args){
        try{
            CustomClassLoader loader = new CustomClassLoader();
            Class.forName("Johar");
            ClassLoader.getSystemClassLoader().loadClass("Johar");

        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
