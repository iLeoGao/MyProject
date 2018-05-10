package com.leogao.learn.realjava.chapter09.exercise.demo02;

class Computer {
    private int     count = 0;
    private String  name  = null;
    private String  style = null;
    private boolean flag  = false;

    public void setName(String name) {
        this.name = name;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getName() {
        return this.name;
    }

    public String getStyle() {
        return this.style;
    }

    public synchronized void set(String name, String style) {
        if (flag) {
            try {
                super.wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.setName(name);
        try {
            Thread.sleep(100);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.setStyle(style);
        System.out.println(Thread.currentThread().getName() + this.getName() + this.getStyle());
        flag = true;
        super.notify();
    }

    public synchronized void get() {
        if (!flag) {
            try {
                super.wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(500);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + this.getName() + this.getStyle());
        flag = false;
        super.notify();
        count++;
    }

    public void say() {
        System.out.println("货取完了，总计：" + count + "台！");
    }
}

class Made implements Runnable {
    private Computer computer = null;

    public Made(Computer computer) {
        this.computer = computer;
    }

    @Override
    public void run() {
        boolean flag = false;
        for (int i = 1; i < 51; i++) {
            if (flag) {
                this.computer.set("笔记本", "，型号：L-7");
                flag = false;
            } else {
                this.computer.set("平板电脑", "，型号：K-4");
                flag = true;
            }
        }
    }
}

class Move implements Runnable {
    private Computer computer = null;

    public Move(Computer computer) {
        this.computer = computer;
    }

    @Override
    public void run() {
        for (int i = 50; i > -1; i--) {
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (i > 0) {
                this.computer.get();
            } else {
                this.computer.say();
            }
        }
    }
}

public class Demo02 {
    public static void main(String args[]) {
        Computer c = new Computer();
        Made ma = new Made(c);
        Move mo = new Move(c);
        new Thread(ma, "生产部生产出：").start();
        new Thread(mo, "物流取走：").start();
    }
}
