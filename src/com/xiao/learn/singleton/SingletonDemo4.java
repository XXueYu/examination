package com.xiao.learn.singleton;
//双检锁
public class SingletonDemo4 {
    private volatile static SingletonDemo4 instance;
    private SingletonDemo4(){}
    public static SingletonDemo4 getInstance(){
        if(instance == null){
            synchronized (SingletonDemo4.class){
                if(instance == null){
                    instance = new SingletonDemo4();
                }
            }
        }
        return instance;
    }
}
