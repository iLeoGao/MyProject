package com.leogao.learn.thinkinjava.holding.exercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.leogao.learn.thinkinjava.net.mindview.util.TextFile;

public class E25_WordsInfo3 {
    public static void main(String[] args) {
        Map<String, ArrayList<Integer>> stat = new HashMap<String, ArrayList<Integer>>();
        int wordCount = 0;
        for (String word : new TextFile("src/com/leogao/learn/thinkinjava/holding/exercise/E25_WordsInfo3.java",
                "\\W+")) {
            ArrayList<Integer> loc = stat.get(word);
            if (loc == null) {
                loc = new ArrayList<Integer>();
                stat.put(word, loc);
            }
            loc.add(++wordCount);
        }
        System.out.println(stat);
    }
}
