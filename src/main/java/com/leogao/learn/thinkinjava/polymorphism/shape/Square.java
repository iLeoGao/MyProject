package com.leogao.learn.thinkinjava.polymorphism.shape;

import static com.leogao.learn.thinkinjava.net.mindview.util.Print.print;

public class Square extends Shape {
    @Override
    public void draw() {
        print("Square.draw()");
    }

    @Override
    public void erase() {
        print("Square.erase()");
    }
} ///:~
