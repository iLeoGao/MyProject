package com.leogao.learn.thinkinjava.containers.exercise;

import java.util.TreeSet;

import com.leogao.learn.thinkinjava.net.mindview.util.CollectionData;
import com.leogao.learn.thinkinjava.net.mindview.util.RandomGenerator;

public class E09_RandTreeSet {
    public static void main(String args[]) {
        TreeSet<String> ts = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
        ts.addAll(CollectionData.list(new RandomGenerator.String(), 10));
        System.out.println("ts = " + ts);
    }
}
