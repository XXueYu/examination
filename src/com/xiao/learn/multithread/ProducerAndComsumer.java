package com.xiao.learn.multithread;

import java.util.ArrayList;

class Kuang{//锁类
    public static ArrayList<Integer> apple = new ArrayList<>();
}
class Farmer implements Runnable{//第一类线程
    @Override
    public void run() {
        while (true){
            synchronized (Kuang.apple){
                if(Kuang.apple.size()==10){
                    System.out.println("筐已满，农夫休息！");
                }else {
                    Kuang.apple.add(1);
                    System.out.println("农夫又放了一个苹果，目前筐里有"+Kuang.apple.size()+"个苹果！");
                }
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

class Child implements Runnable{//小孩线程
    @Override
    public void run() {
        while (true){
            synchronized (Kuang.apple){
                if(Kuang.apple.size()==0){
                    System.out.println("筐已空，小孩没得吃了！");
                }else {
                    Kuang.apple.remove(0);
                    System.out.println("小孩又吃了一个苹果，现在筐里还有！"+Kuang.apple.size()+"个苹果！！！！");
                }
            }
            try {
                Thread.sleep(180);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
public class ProducerAndComsumer {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Farmer());
        Thread t2 = new Thread(new Child());
        t1.start();
        t2.start();
    }
}
