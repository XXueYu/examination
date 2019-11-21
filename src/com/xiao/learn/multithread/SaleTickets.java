package com.xiao.learn.multithread;
public class SaleTickets implements Runnable{

    private int ticket = 30;
    @Override
    public void run() {
        while (ticket>0){
            synchronized (this) {
               if(ticket>0){
                   System.out.println(Thread.currentThread().getName()+"卖了id为"+ticket+"的票！");
                   ticket--;
               }
            }
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SaleTickets mt = new SaleTickets();
        Thread t1 = new Thread(mt);
        t1.setName("窗口1");

        Thread t2 = new Thread(mt);
        t2.setName("窗口2");

        t2.start();
        t1.start();
    }
}
