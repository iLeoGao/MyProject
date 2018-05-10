package com.leogao.learn.thinkinjava.generics;

import java.util.Arrays;
import java.util.List;

public class CompilerIntelligence {
    public static void main(String[] args) {
        List<? extends Fruit> flist = Arrays.asList(new Apple());
        Apple a = (Apple) flist.get(0); // No warning
        System.out.println(flist.contains(new Apple())); // Argument is 'Object'
        System.out.println(flist.indexOf(new Apple())); // Argument is 'Object'

        System.out.println("-- other test --");
        List<String> list2 = Arrays.asList("a", "b", "c", "d");
        System.out.println(list2.contains("a"));
        System.out.println(list2.contains("e"));
        System.out.println(list2.indexOf("b"));
        System.out.println(list2.indexOf("f"));

    }
} ///:~
