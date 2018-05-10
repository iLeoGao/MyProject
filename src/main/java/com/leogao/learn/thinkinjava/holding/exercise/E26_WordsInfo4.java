package com.leogao.learn.thinkinjava.holding.exercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.leogao.learn.thinkinjava.net.mindview.util.TextFile;

public class E26_WordsInfo4 {
    public static void main(String[] args) {
        Map<String, ArrayList<Integer>> stat = new HashMap<String, ArrayList<Integer>>();
        int wordCount = 0;
        List<String> origWords = new TextFile("src/com/leogao/learn/thinkinjava/holding/exercise/E26_WordsInfo4.java",
                "\\W+");
        for (String word : origWords) {
            ArrayList<Integer> loc = stat.get(word);
            if (loc == null) {
                loc = new ArrayList<Integer>();
                stat.put(word, loc);
            }
            loc.add(++wordCount);
        }
        // Now recreate the original order of the words.
        // We will use an inverted structure, where the key
        // is the position of the word in the file. Also,
        // we will sort words based on their positions.
        TreeMap<Integer, String> words = new TreeMap<Integer, String>();
        for (Map.Entry<String, ArrayList<Integer>> entry : stat.entrySet())
            for (Integer pos : entry.getValue())
                words.put(pos, entry.getKey());
        // Test the correctness.
        System.out.println(origWords);
        System.out.println(words.values());
    }
}
