package com.leogao.learn.thinkinjava.generics.exercise;

class Holder4<T> {
    private T a, b, c;

    public Holder4(T a, T b, T c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public void setA(T a) {
        this.a = a;
    }

    public void setB(T b) {
        this.b = b;
    }

    public void setC(T c) {
        this.c = c;
    }

    public T getA() {
        return a;
    }

    public T getB() {
        return b;
    }

    public T getC() {
        return c;
    }
}

public class E02_Holder4 {
    public static void main(String[] args) {
        Holder4<String> h4 = new Holder4<String>("A", "B", "C");
        System.out.println(h4.getA());
        System.out.println(h4.getB());
        System.out.println(h4.getC());
        h4.setC("D");
        System.out.println(h4.getC());
    }
}
