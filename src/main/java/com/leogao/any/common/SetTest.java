package com.leogao.any.common;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SetTest {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("4", "1", "2", "-2", "2", "3");
        // hashSet、linkedHashSet、treeSet对比
        HashSet<String> hashSet = (HashSet<String>) getSet(1, list);
        LinkedHashSet<String> linkedHashSet = (LinkedHashSet<String>) getSet(2, list);
        TreeSet<String> treeSet = (TreeSet<String>) getSet(3, list);
        // 打印输出
        printSet(hashSet);
        printSet(linkedHashSet);
        printSet(treeSet);
        //
        System.out.println();
        // 一减一增
        hashSet.remove("2");
        hashSet.add("2");
        linkedHashSet.remove("2");
        linkedHashSet.add("2");
        treeSet.remove("2");
        treeSet.add("2");
        // 打印输出
        printSet(hashSet);
        printSet(linkedHashSet);
        printSet(treeSet);
    }

    private static Set<String> getSet(Integer n, List<String> list) {
        Set<String> set = new HashSet<String>();
        if (n == 2) {
            set = new LinkedHashSet<String>();
        } else if (n == 3) {
            set = new TreeSet<String>();
        }
        for (int i = 0; i < list.size(); i++) {
            set.add(list.get(i));
        }
        return set;
    }

    private static void printSet(Set<String> set) {
        String describe = "HashSet: ";
        if (set instanceof LinkedHashSet) {
            describe = "LinkedHashSet: ";
            System.out.print("\t" + describe + set.toString());
        } else if (set instanceof TreeSet) {
            describe = "TreeSet: ";
            System.out.print("\t" + describe + set.toString());
        } else {
            System.out.print(describe + set.toString());
        }
    }
}
