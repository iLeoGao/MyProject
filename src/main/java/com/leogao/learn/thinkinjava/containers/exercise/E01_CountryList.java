package com.leogao.learn.thinkinjava.containers.exercise;

import static com.leogao.learn.thinkinjava.net.mindview.util.Countries.names;
import static com.leogao.learn.thinkinjava.net.mindview.util.Print.print;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class E01_CountryList {
    private static Random rnd = new Random(47);

    public static void main(String[] args) {
        List<String> l = new ArrayList<String>(names(8));
        Collections.sort(l);
        print("sorted: " + l);
        for (int i = 1; i < 5; i++) {
            Collections.shuffle(l, rnd);
            print("shuffled (" + i + "): " + l);
        }
    }
}
