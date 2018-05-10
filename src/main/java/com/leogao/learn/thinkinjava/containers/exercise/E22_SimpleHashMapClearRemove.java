package com.leogao.learn.thinkinjava.containers.exercise;

import java.util.Iterator;
import java.util.LinkedList;

import com.leogao.learn.thinkinjava.containers.MapEntry;
import com.leogao.learn.thinkinjava.containers.SimpleHashMap;
import com.leogao.learn.thinkinjava.net.mindview.util.Countries;

class SimpleHashMap3<K, V> extends SimpleHashMap<K, V> {

    static final int             SIZE    = 997;

    @SuppressWarnings("unchecked")
    LinkedList<MapEntry<K, V>>[] buckets = new LinkedList[SIZE];

    @Override
    @SuppressWarnings("unchecked")
    public void clear() {
        // Effectively erase everything by allocating
        // a new empty array of buckets:
        buckets = new LinkedList[SIZE];
    }

    @Override
    public V remove(Object key) {
        // Code is copied from get(), except that
        // before returning the value, the Map.Entry is
        // removed from the list:
        int index = Math.abs(key.hashCode()) % SIZE;
        if (buckets[index] == null)
            return null;
        Iterator<MapEntry<K, V>> it = buckets[index].iterator();
        while (it.hasNext()) {
            MapEntry<K, V> iPair = it.next();
            if (iPair.getKey().equals(key)) {
                // Changes are here:
                V value = iPair.getValue();
                // Removes the last fetched value:
                it.remove();
                return value;
            }
        }
        return null;
    }
}

public class E22_SimpleHashMapClearRemove {
    public static void main(String[] args) {
        SimpleHashMap3<String, String> m = new SimpleHashMap3<String, String>();
        m.putAll(Countries.capitals(10));
        System.out.println(m);
        System.out.println("m.get(\"BURUNDI\") = " + m.get("BURUNDI"));
        System.out.println(m.size());
        m.remove("BURUNDI");
        System.out.println("After removal, m.get(\"BURUNDI\") = " + m.get("BURUNDI"));
        System.out.println(m.size());
        m.clear();
        System.out.println("After clearing: " + m);
        System.out.println(m.size());
    }
}
