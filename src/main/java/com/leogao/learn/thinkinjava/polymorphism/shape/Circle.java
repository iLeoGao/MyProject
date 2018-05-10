package com.leogao.learn.thinkinjava.polymorphism.shape;

import static com.leogao.learn.thinkinjava.net.mindview.util.Print.print;

public class Circle extends Shape {
    @Override
    public void draw() {
        print("Circle.draw()");
    }

    @Override
    public void erase() {
        print("Circle.erase()");
    }
} ///:~
