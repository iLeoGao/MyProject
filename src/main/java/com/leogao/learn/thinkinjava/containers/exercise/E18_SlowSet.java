package com.leogao.learn.thinkinjava.containers.exercise;

import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.leogao.learn.thinkinjava.net.mindview.util.Countries;

class SlowSet<K> extends AbstractSet<K> {
    private List<K> keys = new ArrayList<K>();

    @Override
    public boolean add(K key) {
        if (!contains(key)) {
            keys.add(key);
            return true;
        }
        return false;
    }

    @Override
    public Iterator<K> iterator() {
        return keys.iterator();
    }

    @Override
    public int size() {
        return keys.size();
    }
}

public class E18_SlowSet {
    public static void main(String[] args) {
        SlowSet<String> slowSet = new SlowSet<String>();
        slowSet.addAll(Countries.names(10));
        slowSet.addAll(Countries.names(10));
        slowSet.addAll(Countries.names(10));
        System.out.println(slowSet);
    }
} /*
   * Output: [ALGERIA, ANGOLA, BENIN, BOTSWANA, BURKINA FASO, BURUNDI, CAMEROON,
   * CAPE VERDE, CENTRAL AFRICAN REPUBLIC, CHAD]
   *///:~
