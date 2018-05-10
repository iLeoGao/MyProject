package com.leogao.learn.thinkinjava.generics.exercise;

import java.util.List;
import java.util.Set;

import com.leogao.learn.thinkinjava.net.mindview.util.New;
import com.leogao.learn.thinkinjava.net.mindview.util.SixTuple;

public class E12_NewTest2 {
    static void f(List<SixTuple<Byte, Short, String, Float, Double, Integer>> l) {
        l.add(new SixTuple<Byte, Short, String, Float, Double, Integer>((byte) 1, (short) 1, "A", 1.0F, 1.0, 1));
        System.out.println(l);
    }

    static void g(Set<Sequence<String>> s) {
        s.add(new Sequence<String>(5));
        System.out.println(s);
    }

    public static void main(String[] args) {
        f(New.<SixTuple<Byte, Short, String, Float, Double, Integer>> list());

        g(New.<Sequence<String>> set());
    }
} /*
   * Output: (78% match) [(1, 1, A, 1.0, 1.0, 1)] [Sequence@3e25a5]
   *///:~
