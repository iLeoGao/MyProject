package com.leogao.learn.thinkinjava.arrays.exercise;

import java.util.Arrays;

public class E05_NonPrimitiveMultiDArray {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Object[3][3][3]));
    }
} /*
   * Output: [[[null, null, null], [null, null, null], [null, null, null]],
   * [[null, null, null], [null, null, null], [null, null, null]], [[null, null,
   * null], [null, null, null], [null, null, null]]]
   *///:~
