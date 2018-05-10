package com.leogao.learn.thinkinjava.holding;

import java.util.Set;
import java.util.TreeSet;

import com.leogao.learn.thinkinjava.net.mindview.util.TextFile;

public class UniqueWords {
    public static void main(String[] args) {
        Set<String> words = new TreeSet<String>(
                new TextFile("src/com/leogao/learn/thinkinjava/holding/UniqueWords.java", "\\W+"));
        System.out.println(words);
    }
} /*
   * Output: [A, B, C, Collections, D, E, F, G, H, HashSet, I, J, K, L, M, N,
   * Output, Print, Set, SetOperations, String, X, Y, Z, add, addAll, added,
   * args, class, contains, containsAll, false, from, holding, import, in, java,
   * main, mindview, net, new, print, public, remove, removeAll, removed, set1,
   * set2, split, static, to, true, util, void]
   *///:~
