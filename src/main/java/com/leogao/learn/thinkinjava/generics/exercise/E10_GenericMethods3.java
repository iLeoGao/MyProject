package com.leogao.learn.thinkinjava.generics.exercise;

public class E10_GenericMethods3 {
    public <T> void f(String t, T x, T y) {
        System.out.println(t.getClass().getName() + ", " + x.getClass().getName() + ", " + y.getClass().getName());
    }

    public static void main(String[] args) {
        E10_GenericMethods3 gm = new E10_GenericMethods3();
        gm.f("Str", 1, 1.0);
        gm.f("Str", 1.0, 1.0F);
        gm.f("Str", 1.0F, 'c');
        gm.f("Str", 'c', gm);
        gm.f("Str", gm, "");
        gm.f("Str", "", 1);
    }
} /*
   * Output: java.lang.String, java.lang.Integer, java.lang.Double
   * java.lang.String, java.lang.Double, java.lang.Float java.lang.String,
   * java.lang.Float, java.lang.Character java.lang.String, java.lang.Character,
   * com.leogao.learn.thinkinjava.generics.exercise.E10_GenericMethods3
   * java.lang.String,
   * com.leogao.learn.thinkinjava.generics.exercise.E10_GenericMethods3,
   * java.lang.String java.lang.String, java.lang.String, java.lang.Integer
   *///:~
