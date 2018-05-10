package com.leogao.any.common;

import java.util.HashSet;
import java.util.Set;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

abstract class AbstractClass {
    abstract void toBeReal();
}

public class RandomTest extends AbstractClass {
    public static void main(String[] args) {

        Set<String> set = new HashSet<String>();
        set.add("1");
        set.add("2");
        set.add("2");
        set.add("3");
        System.out.println(set.toString());

        Set<String> set2 = new HashSet<String>();
        set2.add("3");
        set2.add("3");
        set2.add("2");
        set2.add("1");
        System.out.println(JSON.toJSONString(set2));

    }

    @Override
    void toBeReal() {
        // TODO Auto-generated method stub

    }

}
