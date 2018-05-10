package com.leogao.learn.thinkinjava.arrays.exercise;

import java.util.Arrays;

public class E06_Filling2DArray {
    static BerylliumSphere[][] fill(int xLen, int yLen) {
        BerylliumSphere[][] a = new BerylliumSphere[xLen][yLen];
        for (int i = 0; i < xLen; i++)
            for (int j = 0; j < yLen; j++)
                a[i][j] = new BerylliumSphere();
        return a;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(fill(3, 3)));
    }
} /*
   * Output: [[Sphere 0, Sphere 1, Sphere 2], [Sphere 3, Sphere 4, Sphere 5],
   * [Sphere 6, Sphere 7, Sphere 8]]
   *///:~