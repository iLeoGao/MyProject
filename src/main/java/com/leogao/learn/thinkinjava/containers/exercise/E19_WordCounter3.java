package com.leogao.learn.thinkinjava.containers.exercise;

import java.util.List;

import com.leogao.learn.thinkinjava.containers.SimpleHashMap;
import com.leogao.learn.thinkinjava.net.mindview.util.TextFile;

public class E19_WordCounter3 {
    public static void main(String[] args) {
        List<String> words = new TextFile("src/com/leogao/learn/thinkinjava/containers/exercise/E19_WordCounter3.java",
                "\\W+");
        SimpleHashMap<String, Integer> map = new SimpleHashMap<String, Integer>();
        for (String word : words) {
            Integer freq = map.get(word);
            map.put(word, freq == null ? 1 : freq + 1);
        }
        System.out.println(map);
    }
}
