package com.xiao.learn.singleton;
//懒汉模式：线程安全
public class SingletonDemo3 {
    private static SingletonDemo3 instance;
    private SingletonDemo3(){}
    public static synchronized SingletonDemo3 getInstance(){
        if(instance==null){
            instance = new SingletonDemo3();
        }
        return instance;
    }
}
