package com.leogao.learn.thinkinjava.containers.exercise;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

import com.leogao.learn.thinkinjava.containers.MapEntry;
import com.leogao.learn.thinkinjava.containers.TestParam;

class SimpleHashMap6<K, V> extends AbstractMap<K, V> {
    static final int            SIZE    = 997;
    @SuppressWarnings("unchecked")
    ArrayList<MapEntry<K, V>>[] buckets = new ArrayList[SIZE];

    @Override
    public V put(K key, V value) {
        V oldValue = null;
        int index = Math.abs(key.hashCode()) % SIZE;
        if (buckets[index] == null)
            buckets[index] = new ArrayList<MapEntry<K, V>>();
        ArrayList<MapEntry<K, V>> bucket = buckets[index];
        MapEntry<K, V> pair = new MapEntry<K, V>(key, value);
        boolean found = false;
        ListIterator<MapEntry<K, V>> it = bucket.listIterator();
        while (it.hasNext()) {
            MapEntry<K, V> iPair = it.next();
            if (iPair.getKey().equals(key)) {
                oldValue = iPair.getValue();
                it.set(pair); // Replace old with new
                found = true;
                break;
            }
        }
        if (!found)
            buckets[index].add(pair);
        return oldValue;
    }

    @Override
    public V get(Object key) {
        int index = Math.abs(key.hashCode()) % SIZE;
        if (buckets[index] == null)
            return null;
        for (MapEntry<K, V> iPair : buckets[index])
            if (iPair.getKey().equals(key))
                return iPair.getValue();
        return null;
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = new HashSet<Map.Entry<K, V>>();
        for (ArrayList<MapEntry<K, V>> bucket : buckets) {
            if (bucket == null)
                continue;
            for (MapEntry<K, V> mpair : bucket)
                set.add(mpair);
        }
        return set;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void clear() {
        // Effectively erase everything by allocating
        // a new empty array of buckets:
        buckets = new ArrayList[SIZE];
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

    @Override
    public int size() {
        // Could rely on the inherited implementation, which
        // returns entrySet().size(), but this is faster:
        int sz = 0;
        for (ArrayList<MapEntry<K, V>> bucket : buckets)
            if (bucket != null)
                sz += bucket.size();
        return sz;
    }

    @Override
    public boolean isEmpty() {
        // Could just say return size() == 0;
        // but this is faster:
        for (ArrayList<MapEntry<K, V>> bucket : buckets)
            if (bucket != null)
                return false;
        return true;
    }

    @Override
    public boolean containsKey(Object key) {
        // A slight modification of the previous method:
        for (ArrayList<MapEntry<K, V>> bucket : buckets) {
            if (bucket == null)
                continue;
            for (MapEntry<K, V> mPair : bucket)
                if (mPair.getKey().equals(key))
                    return true;
        }
        return false;
    }
}

public class E37_SimpleHashMapArrays {
    public static void main(String[] args) {
        if (args.length > 0)
            Tester.defaultParams = TestParam.array(args);
        Tester.run(new SimpleHashMap4<Integer, Integer>(), E35_MapPerformance2.tests);
        Tester.run(new SimpleHashMap5<Integer, Integer>(), E35_MapPerformance2.tests);
        Tester.run(new SimpleHashMap6<Integer, Integer>(), E35_MapPerformance2.tests);
    }
}
