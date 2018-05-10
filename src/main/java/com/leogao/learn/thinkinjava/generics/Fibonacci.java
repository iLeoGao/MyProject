package com.leogao.learn.thinkinjava.generics;

import com.leogao.learn.thinkinjava.net.mindview.util.Generator;

public class Fibonacci implements Generator<Integer> {
    private int count = 0;

    @Override
    public Integer next() {
        return fib(count++);
    }

    private int fib(int n) {
        if (n < 2)
            return 1;
        return fib(n - 2) + fib(n - 1);
    }

    public static void main(String[] args) {
        Fibonacci gen = new Fibonacci();
        for (int i = 0; i < 30; i++) {
            Long beginTime = System.currentTimeMillis();
            System.out.println(
                    "id=" + (i + 1) + " " + gen.next() + " 耗时=" + (System.currentTimeMillis() - beginTime) + "ms");
        }
    }
} /*
   * Output: 1 1 2 3 5 8 13 21 34 55 89 144 233 377 610 987 1597 2584
   *///:~
