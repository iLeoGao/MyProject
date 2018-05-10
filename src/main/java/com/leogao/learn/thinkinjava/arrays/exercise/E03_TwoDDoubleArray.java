package com.leogao.learn.thinkinjava.arrays.exercise;

import static com.leogao.learn.thinkinjava.net.mindview.util.Print.print;

import java.util.Locale;

public class E03_TwoDDoubleArray {
    public static double[][] twoDDoubleArray(int xLen, int yLen, double valStart, double valEnd) {
        double[][] array = new double[xLen][yLen];
        double increment = (valEnd - valStart) / (xLen * yLen);
        double val = valStart;
        for (int i = 0; i < array.length; i++)
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = val;
                val += increment;
            }
        return array;
    }

    public static void printArray(double[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++)
                System.out.printf(Locale.US, "%.2f ", array[i][j]);
            print();
        }
    }

    public static void main(String args[]) {
        double[][] twoD = twoDDoubleArray(4, 6, 47.0, 99.0);
        printArray(twoD);
        print("**********************");
        double[][] twoD2 = twoDDoubleArray(2, 2, 47.0, 99.0);
        printArray(twoD2);
        print("**********************");
        double[][] twoD3 = twoDDoubleArray(9, 5, 47.0, 99.0);
        printArray(twoD3);
    }
} /*
   * Output: 47.00 49.17 51.33 53.50 55.67 57.83 60.00 62.17 64.33 66.50 68.67
   * 70.83 73.00 75.17 77.33 79.50 81.67 83.83 86.00 88.17 90.33 92.50 94.67
   * 96.83 47.00 60.00 73.00 86.00 47.00 48.16 49.31 50.47 51.62 52.78 53.93
   * 55.09 56.24 57.40 58.56 59.71 60.87 62.02 63.18 64.33 65.49 66.64 67.80
   * 68.96 70.11 71.27 72.42 73.58 74.73 75.89 77.04 78.20 79.36 80.51 81.67
   * 82.82 83.98 85.13 86.29 87.44 88.60 89.76 90.91 92.07 93.22 94.38 95.53
   * 96.69 97.84
   *///:~
