package com.leogao.learn.thinkinjava.holding.exercise;

import java.util.Iterator;
import java.util.Random;

import com.leogao.learn.thinkinjava.polymorphism.shape.Circle;
import com.leogao.learn.thinkinjava.polymorphism.shape.Shape;
import com.leogao.learn.thinkinjava.polymorphism.shape.Square;
import com.leogao.learn.thinkinjava.polymorphism.shape.Triangle;

class RandomShapeGenerator implements Iterable<Shape> {
    private Random    rand = new Random(47);
    private final int quantity;

    RandomShapeGenerator(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public Iterator<Shape> iterator() {
        return new Iterator<Shape>() {
            private int count;

            @Override
            public boolean hasNext() {
                return count < quantity;
            }

            @Override
            public Shape next() {
                ++count;
                return nextShape();
            }

            @Override
            public void remove() { // Not implemented
                throw new UnsupportedOperationException();
            }
        };
    }

    private Shape nextShape() {
        switch (rand.nextInt(3)) {
            default:
            case 0:
                return new Circle();
            case 1:
                return new Square();
            case 2:
                return new Triangle();
        }
    }
}

public class E31_IterableRandomShapeGenerator {
    public static void main(String[] args) {
        RandomShapeGenerator rsg = new RandomShapeGenerator(10);
        for (Shape shape : rsg)
            System.out.println(shape.getClass().getSimpleName());
    }
}
