package com.xiao.learn.singleton;
//登记式/静态内部类
public class SingeltonDemo5 {
    private SingeltonDemo5(){}
    private static class SingletonDemo5Handler{
        private static final SingeltonDemo5 INSTANCE = new SingeltonDemo5();
    }
    public static SingeltonDemo5 getInstance(){
        return SingletonDemo5Handler.INSTANCE;
    }
}
