package com.johar.javawebdemo.singleton;

public enum EnumInstance {
    INSTANCE;

    public static EnumInstance getInstance(){
        return INSTANCE;
    }
}
