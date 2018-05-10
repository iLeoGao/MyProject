package com.leogao.learn.thinkinjava.arrays.exercise;

import java.util.Arrays;

public class E02_ReturningArray {
    static BerylliumSphere[] createArray(int size) {
        BerylliumSphere[] a = new BerylliumSphere[size];
        for (int i = 0; i < size; i++)
            a[i] = new BerylliumSphere();
        return a;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(createArray(10)));
    }
} /*
   * Output: [Sphere 0, Sphere 1, Sphere 2, Sphere 3, Sphere 4, Sphere 5, Sphere
   * 6, Sphere 7, Sphere 8, Sphere 9]
   *///:~
