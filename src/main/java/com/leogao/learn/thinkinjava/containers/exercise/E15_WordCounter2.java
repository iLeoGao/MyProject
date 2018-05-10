package com.leogao.learn.thinkinjava.containers.exercise;

import java.util.List;

import com.leogao.learn.thinkinjava.containers.SlowMap;
import com.leogao.learn.thinkinjava.net.mindview.util.TextFile;

public class E15_WordCounter2 {
    public static void main(String[] args) {
        List<String> words = new TextFile("src/com/leogao/learn/thinkinjava/containers/exercise/E15_WordCounter2.java",
                "\\W+");
        SlowMap<String, Integer> map = new SlowMap<String, Integer>();
        for (String word : words) {
            Integer freq = map.get(word);
            map.put(word, freq == null ? 1 : freq + 1);
        }
        System.out.println(map);
    }
}
