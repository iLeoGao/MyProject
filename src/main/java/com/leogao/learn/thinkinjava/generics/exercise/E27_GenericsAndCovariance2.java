package com.leogao.learn.thinkinjava.generics.exercise;

import java.util.ArrayList;
import java.util.List;

public class E27_GenericsAndCovariance2 {
    public static void main(String[] args) {
        // Compile Error: incompatible types:
        // List<Number> nlist = new ArrayList<Integer>();
        // Wildcards allow covariance:
        List<? extends Number> nlist = new ArrayList<Integer>();
        // Compile Error: can't add any type of object:
        // nlist.add(new Integer(1));
        // nlist.add(new Float(1.0));
        // nlist.add(new Object());
        nlist.add(null); // Legal but uninteresting
        // We know that it returns at least Number:
        Number n = nlist.get(0);
    }
}
