package com.leogao.any.common;

public class ArgsTest {
    public static void main(String[] args) {
        String a = args[0];
        String b = args[1];
        System.out.println("a=" + a + ", b=" + b + " a=b?" + a.equals(b));
        for (String s : args) {
            System.out.println(s);
        }
    }
}
