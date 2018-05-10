package com.leogao.any.common.thread;

/**
 * 建立三个线程，A线程打印10次A，B线程打印10次B，C线程打印10次C，要求线程同时运行，交替打印10次ABC。
 * 
 * @author leogao 2018年4月19日 上午11:43:30
 */
public class TreadDemo implements Runnable {

    private String name;
    private Object prev;
    private Object self;

    private TreadDemo(String name, Object prev, Object self) {
        this.name = name;
        this.prev = prev;
        this.self = self;
    }

    @Override
    public void run() {
        int count = 10;
        while (count > 0) {
            synchronized (prev) {
                synchronized (self) {
                    System.out.print(name);
                    count--;
                    self.notify();
                }
                try {
                    prev.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();
        TreadDemo pa = new TreadDemo("A", c, a);
        TreadDemo pb = new TreadDemo("B", a, b);
        TreadDemo pc = new TreadDemo("C", b, c);

        new Thread(pa).start();
        Thread.sleep(100); //确保按顺序A、B、C执行
        new Thread(pb).start();
        Thread.sleep(100);
        new Thread(pc).start();
        Thread.sleep(100);
    }
}
