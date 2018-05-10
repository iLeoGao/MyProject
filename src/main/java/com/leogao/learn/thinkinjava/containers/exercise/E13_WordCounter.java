package com.leogao.learn.thinkinjava.containers.exercise;

import java.util.List;

import com.leogao.learn.thinkinjava.net.mindview.util.TextFile;

class AssociativeArray<K, V> {
    private Object[][] pairs;
    private int        index;

    public AssociativeArray(int length) {
        pairs = new Object[length][2];
    }

    public void put(K key, V value) {
        for (int i = 0; i < index; i++)
            if (key.equals(pairs[i][0])) {
                pairs[i] = new Object[] { key, value };
                return;
            }
        if (index >= pairs.length)
            throw new ArrayIndexOutOfBoundsException();
        pairs[index++] = new Object[] { key, value };
    }

    @SuppressWarnings("unchecked")
    public V get(K key) {
        for (int i = 0; i < index; i++)
            if (key.equals(pairs[i][0]))
                return (V) pairs[i][1];
        return null; // Did not find key
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < index; i++) {
            result.append(pairs[i][0].toString());
            result.append(" : ");
            result.append(pairs[i][1].toString());
            if (i < index - 1)
                result.append("\n");
        }
        return result.toString();
    }
}

public class E13_WordCounter {
    public static void main(String[] args) {
        List<String> words = new TextFile("src/com/leogao/learn/thinkinjava/containers/exercise/E13_WordCounter.java",
                "\\W+");
        AssociativeArray<String, Integer> map = new AssociativeArray<String, Integer>(words.size());
        for (String word : words) {
            Integer freq = map.get(word);
            map.put(word, freq == null ? 1 : freq + 1);
        }
        System.out.println(map);
    }
}
