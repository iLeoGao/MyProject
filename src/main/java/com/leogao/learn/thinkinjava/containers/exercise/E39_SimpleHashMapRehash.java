package com.leogao.learn.thinkinjava.containers.exercise;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;

import com.leogao.learn.thinkinjava.containers.MapEntry;
import com.leogao.learn.thinkinjava.containers.SimpleHashMap;
import com.leogao.learn.thinkinjava.net.mindview.util.Countries;

@SuppressWarnings("unchecked")
class SimpleHashMap7<K, V> extends SimpleHashMap<K, V> {
    private int                  count;                                          // Number of elements
    private static final double  loadFactor      = 0.75;
    // Use a prime initial capacity; the JDK uses a number,
    // which is a power of 2:
    private final static int     initialCapacity = 11;
    private int                  capacity        = initialCapacity;
    private int                  threshold       = (int) (capacity * loadFactor);

    static final int             SIZE            = 997;

    @SuppressWarnings("unchecked")
    LinkedList<MapEntry<K, V>>[] buckets         = new LinkedList[SIZE];
    {
        buckets = new LinkedList[capacity];
    }

    @Override
    public V put(K key, V value) {
        V oldValue = null;
        int index = Math.abs(key.hashCode()) % capacity;
        if (buckets[index] == null)
            buckets[index] = new LinkedList<MapEntry<K, V>>();
        LinkedList<MapEntry<K, V>> bucket = buckets[index];
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
        if (!found) {
            if (count >= threshold)
                rehash();
            if (buckets[index] == null)
                buckets[index] = new LinkedList<MapEntry<K, V>>();
            buckets[index].add(pair);
            ++count;
        }
        return oldValue;
    }

    private boolean isPrime(int candidate) {
        for (int j = 2; j < candidate; j++)
            if (candidate % j == 0)
                return false;
        return true;
    }

    private int nextPrime(int candidate) {
        while (!isPrime(candidate))
            candidate++;
        return candidate;
    }

    private void rehash() {
        // Points to a new Set of the entries, so it
        // won't be bothered by what we're about to do:
        Iterator<Map.Entry<K, V>> it = entrySet().iterator();
        // Get next prime capacity:
        capacity = nextPrime(capacity * 2);
        System.out.println("Rehashing, new capacity = " + capacity);
        buckets = new LinkedList[capacity];
        threshold = (int) (capacity * loadFactor);
        count = 0;
        // Fill new buckets (crude, but it works):
        while (it.hasNext()) {
            Map.Entry<K, V> me = it.next();
            put(me.getKey(), me.getValue());
        }
    }

}

public class E39_SimpleHashMapRehash {
    public static void main(String[] args) {
        SimpleHashMap7<String, String> m = new SimpleHashMap7<String, String>();
        m.putAll(Countries.capitals(50));
        System.out.println(m);
    }
}
