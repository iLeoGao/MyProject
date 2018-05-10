package com.leogao.any.common.thread;

public class ThreadDemo01 extends Thread {
    public ThreadDemo01() {
        //编写子类的构造方法，可缺省
    }

    @Override
    public void run() {
        //编写自己的线程代码
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        ThreadDemo01 threadDemo01 = new ThreadDemo01();
        threadDemo01.setName("我是自定义的线程1");
        threadDemo01.start();
        System.out.println(Thread.currentThread().toString());

        ThreadDemo01 threadDemo02 = new ThreadDemo01();
        threadDemo02.setName("我是自定义的线程2");
        threadDemo02.start();
        System.out.println(Thread.currentThread().toString());
    }
}
