package com.leogao.any.common;

import java.util.List;

import com.alibaba.fastjson.JSON;

public class FloatTest {
    public static void main(String[] args) {
        System.out.println("123");
        float a = 2.0f;
        float f[][] = new float[6][6];
        float[] f2[] = new float[6][6];
        float[][] f3 = new float[6][6];
        float f4[][] = new float[6][];
        //  float f5[][] = new float[][6];
        System.out.println(JSON.toJSONString(f));
        System.out.println(JSON.toJSONString(f2));
        System.out.println(JSON.toJSONString(f3));
        System.out.println(JSON.toJSONString(f4));

        int m[] = { 0, 1, 2, 3, 4, 5, 6 };
        int k = m.length;
        List<String> b = null;
        b.size();

    }
}
