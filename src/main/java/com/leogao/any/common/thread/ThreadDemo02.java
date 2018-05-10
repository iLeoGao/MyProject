package com.leogao.any.common.thread;

public class ThreadDemo02 {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        Thread t1 = new Thread(new MyThread());
        t1.start();
        Thread t2 = new Thread(new MyThread());
        t2.start();
    }
}

class MyThread implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "-->我是通过实现接口的线程实现方式！");
    }
}
