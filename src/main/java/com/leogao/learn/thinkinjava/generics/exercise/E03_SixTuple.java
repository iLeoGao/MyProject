package com.leogao.learn.thinkinjava.generics.exercise;

import com.leogao.learn.thinkinjava.net.mindview.util.FiveTuple;

class SixTuple<A, B, C, D, E, F> extends FiveTuple<A, B, C, D, E> {
    public final F sixth;

    public SixTuple(A a, B b, C c, D d, E e, F f) {
        super(a, b, c, d, e);
        sixth = f;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ", " + third + ", " + fourth + ", " + fifth + ", " + sixth + ")";
    }
}

public class E03_SixTuple {
    static SixTuple<Vehicle, Amphibian, String, Float, Double, Byte> a() {
        return new SixTuple<Vehicle, Amphibian, String, Float, Double, Byte>(new Vehicle(), new Amphibian(), "hi",
                (float) 4.7, 1.1, (byte) 1);
    }

    public static void main(String[] args) {
        System.out.println(a());
    }
}
