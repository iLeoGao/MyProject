package com.leogao.learn.thinkinjava.containers.exercise;

import static com.leogao.learn.thinkinjava.net.mindview.util.Print.print;

import java.util.HashMap;
import java.util.Map;

import com.leogao.learn.thinkinjava.net.mindview.util.Countries;

public class E38_HashMapLoadFactor {
    public static void testGet(Map<String, String> filledMap, int n) {
        for (int tc = 0; tc < 1000000; tc++)
            for (int i = 0; i < Countries.DATA.length; i++) {
                String key = Countries.DATA[i][0];
                filledMap.get(key);
            }
    }

    public static void main(String args[]) {
        // Initial capacity 16:
        HashMap<String, String> map1 = new HashMap<String, String>();
        // Fill to less than threshold:
        map1.putAll(Countries.capitals(11));
        // Initial capacity 32:
        HashMap<String, String> map2 = new HashMap<String, String>(32);
        map2.putAll(map1);
        long t1 = System.currentTimeMillis();
        testGet(map1, 11);
        long t2 = System.currentTimeMillis();
        print("map1 : " + (t2 - t1));
        t1 = System.currentTimeMillis();
        testGet(map2, 11);
        t2 = System.currentTimeMillis();
        print("map2 : " + (t2 - t1));
    }
}
