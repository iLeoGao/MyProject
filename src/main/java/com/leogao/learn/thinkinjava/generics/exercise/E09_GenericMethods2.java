package com.leogao.learn.thinkinjava.generics.exercise;

public class E09_GenericMethods2 {
    public <T> void f(T t, T x, T y) {
        System.out.println(t.getClass().getName() + ", " + x.getClass().getName() + ", " + y.getClass().getName());
    }

    public static void main(String[] args) {
        E09_GenericMethods2 gm = new E09_GenericMethods2();
        gm.f("", 1, 1.0);
        gm.f(1, 1.0, 1.0F);
        gm.f(1.0, 1.0F, 'c');
        gm.f(1.0F, 'c', gm);
        gm.f('c', gm, "");
        gm.f(gm, "", 1);
    }
} /*
   * Output: java.lang.String, java.lang.Integer, java.lang.Double
   * java.lang.Integer, java.lang.Double, java.lang.Float java.lang.Double,
   * java.lang.Float, java.lang.Character java.lang.Float, java.lang.Character,
   * com.leogao.learn.thinkinjava.generics.exercise.E09_GenericMethods2
   * java.lang.Character,
   * com.leogao.learn.thinkinjava.generics.exercise.E09_GenericMethods2,
   * java.lang.String
   * com.leogao.learn.thinkinjava.generics.exercise.E09_GenericMethods2,
   * java.lang.String, java.lang.Integer
   *///:~
