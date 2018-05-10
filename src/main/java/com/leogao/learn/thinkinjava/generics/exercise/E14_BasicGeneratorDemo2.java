package com.leogao.learn.thinkinjava.generics.exercise;

import com.leogao.learn.thinkinjava.generics.CountedObject;
import com.leogao.learn.thinkinjava.net.mindview.util.BasicGenerator;
import com.leogao.learn.thinkinjava.net.mindview.util.Generator;

public class E14_BasicGeneratorDemo2 {
    public static void main(String[] args) {
        Generator<CountedObject> gen = new BasicGenerator<CountedObject>(CountedObject.class);
        for (int i = 0; i < 5; i++)
            System.out.println(gen.next());
    }
}
