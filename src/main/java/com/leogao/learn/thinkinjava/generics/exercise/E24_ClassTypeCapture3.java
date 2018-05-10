package com.leogao.learn.thinkinjava.generics.exercise;

import static com.leogao.learn.thinkinjava.net.mindview.util.Print.print;

import java.util.HashMap;
import java.util.Map;

class FactoryCapture {
    Map<String, FactoryI<?>> factories = new HashMap<String, FactoryI<?>>();

    public Object createNew(String typename, int arg) {
        FactoryI<?> f = factories.get(typename);
        try {
            return f.create(arg);
        } catch (NullPointerException e) {
            print("Not a registered typename: " + typename);
            return null;
        }
    }

    public void addFactory(String typename, FactoryI<?> kind) {
        factories.put(typename, kind);
    }
}

public class E24_ClassTypeCapture3 {
    public static void main(String[] args) {
        FactoryCapture fc = new FactoryCapture();
        fc.addFactory("Integer", new IntegerFactory());
        fc.addFactory("Widget", new Widget.Factory());
        print(fc.createNew("Integer", 1));
        print(fc.createNew("Widget", 1));

        fc.createNew("Product", 1);
    }
}
