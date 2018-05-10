package com.leogao.learn.thinkinjava.containers.exercise;

import static com.leogao.learn.thinkinjava.net.mindview.util.Countries.capitals;
import static com.leogao.learn.thinkinjava.net.mindview.util.Countries.names;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class E02_ACountries {
    public static void main(String[] args) {
        TreeMap<String, String> map = new TreeMap<String, String>(capitals());
        TreeSet<String> set = new TreeSet<String>(names());
        String b = null;
        for (String s : map.keySet())
            if (s.startsWith("B")) {
                b = s;
                break;
            }
        Map<String, String> aMap = map.headMap(b);
        Set<String> aSet = set.headSet(b);
        System.out.println("aMap = " + aMap);
        System.out.println("aSet = " + aSet);
    }
}
