package com.leogao.any.common.thread;

public class ThreadDemo {
    public static void main(String[] args) {
        MyThread06 mt = new MyThread06();
        Thread t = new Thread(mt, "OldThread");
        t.start();
        for (int i = 0; i < 10; i++) {
            if (i > 5) {
                try {
                    t.join();
                } catch (Exception e) {

                }
            }
            System.out.println("Main() -- " + i);
        }
    }
}

class MyThread06 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "--" + i);
        }
    }

}
