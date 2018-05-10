package com.leogao.learn.thinkinjava.generics.exercise;

import java.util.HashSet;
import java.util.Set;

import com.leogao.learn.thinkinjava.net.mindview.util.Sets;

public class SetsTest {
    public static void main(String[] args) {
        Set<String> setA = new HashSet<String>();
        setA.add("a");
        setA.add("c");
        Set<String> setB = new HashSet<String>();
        setB.add("b");
        setB.add("c");
        System.out.println(Sets.union(setA, setB));
        System.out.println(Sets.intersection(setA, setB));
        System.out.println(Sets.difference(setA, setB));
        System.out.println(Sets.complement(setA, setB));
    }
}
