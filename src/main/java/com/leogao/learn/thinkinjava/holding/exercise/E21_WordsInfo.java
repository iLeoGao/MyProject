package com.leogao.learn.thinkinjava.holding.exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.leogao.learn.thinkinjava.net.mindview.util.TextFile;

public class E21_WordsInfo {
    public static void main(String[] args) {
        Map<String, Integer> wordsStat = new HashMap<String, Integer>();
        for (String word : new TextFile("src/com/leogao/learn/thinkinjava/holding/exercise/E21_WordsInfo.java",
                "\\W+")) {
            Integer freq = wordsStat.get(word);
            wordsStat.put(word, freq == null ? 1 : freq + 1);
        }
        List<String> keys = new ArrayList<String>(wordsStat.keySet());
        Collections.sort(keys, String.CASE_INSENSITIVE_ORDER);
        for (String key : keys)
            System.out.println(key + " => " + wordsStat.get(key));
    }
}
