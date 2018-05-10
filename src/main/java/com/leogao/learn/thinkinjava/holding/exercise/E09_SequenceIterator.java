package com.leogao.learn.thinkinjava.holding.exercise;

import java.util.Iterator;
import java.util.NoSuchElementException;

class Sequence2 {
    private Object[] items;
    private int      next;

    public Sequence2(int size) {
        items = new Object[size];
    }

    public void add(Object x) {
        if (next < items.length)
            items[next++] = x;
    }

    private class SequenceIterator implements Iterator<Object> {
        private int i;

        @Override
        public boolean hasNext() {
            return i < items.length;
        }

        @Override
        public Object next() {
            if (hasNext())
                return items[i++];
            throw new NoSuchElementException();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public Iterator<Object> iterator() {
        return new SequenceIterator();
    }
}

public class E09_SequenceIterator {
    public static void main(String[] args) {
        Sequence2 sequence = new Sequence2(10);
        for (int i = 0; i < 10; i++)
            sequence.add(Integer.toString(i));
        for (Iterator<Object> it = sequence.iterator(); it.hasNext();)
            System.out.print(it.next() + " ");
    }
} /* Output: 0123456789 *///:~
