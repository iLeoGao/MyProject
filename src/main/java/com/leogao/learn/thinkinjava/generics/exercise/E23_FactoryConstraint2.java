package com.leogao.learn.thinkinjava.generics.exercise;

interface FactoryI<T> {
    T create(int arg);
}

class Foo<T> {
    private T x;

    public Foo(FactoryI<T> factory) {
        x = factory.create(1);
    }
    // ...
}

class IntegerFactory implements FactoryI<Integer> {
    @Override
    public Integer create(int arg) {
        return new Integer(arg);
    }
}

class Widget {
    private final int id;

    Widget(int ident) {
        id = ident;
    }

    @Override
    public String toString() {
        return "Widgt " + id;
    }

    public static class Factory implements FactoryI<Widget> {
        @Override
        public Widget create(int arg) {
            return new Widget(arg);
        }
    }
}

public class E23_FactoryConstraint2 {
    public static void main(String[] args) {
        new Foo<Integer>(new IntegerFactory());
        new Foo<Widget>(new Widget.Factory());
    }
} ///:~
