
/**
 * 类package-info.java的实现描述：TODO 类实现描述 
 * @author leogao 2018年3月14日 下午4:04:32
 */
package com.leogao.learn.thinkinjava.generics.exercise;

import java.util.Iterator;

import com.leogao.learn.thinkinjava.generics.Fibonacci;

class IterableFibonacci implements Iterable<Integer> {
    private Fibonacci fib = new Fibonacci();
    private int       n;

    public IterableFibonacci(int count) {
        n = count;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return n > 0;
            }

            @Override
            public Integer next() {
                --n;
                return fib.next();
            }

            @Override
            public void remove() { // Not implemented
                throw new UnsupportedOperationException();
            }
        };
    }
}

public class E07_IterableFibonacci2 {
    public static void main(String[] args) {
        for (int i : new IterableFibonacci(18))
            System.out.print(i + " ");
    }
} /*
   * Output: 1 1 2 3 5 8 13 21 34 55 89 144 233 377 610 987 1597 2584
   *///:~                      
