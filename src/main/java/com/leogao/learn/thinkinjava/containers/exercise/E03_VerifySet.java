package com.leogao.learn.thinkinjava.containers.exercise;

import static com.leogao.learn.thinkinjava.net.mindview.util.Countries.names;

import java.util.LinkedHashSet;
import java.util.Set;

public class E03_VerifySet {
    public static void main(String[] args) {
        Set<String> set = new LinkedHashSet<String>();
        for (int i = 0; i < 5; i++)
            set.addAll(names(10));
        System.out.println(set);
    }
}
