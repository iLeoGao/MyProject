package com.leogao.learn.thinkinjava.generics.exercise;

import java.util.ArrayList;
import java.util.Random;

import com.leogao.learn.thinkinjava.generics.Generators;
import com.leogao.learn.thinkinjava.net.mindview.util.Generator;

class Product {
    private final int id;
    private String    description;
    private double    price;

    public Product(int IDnumber, String descr, double price) {
        id = IDnumber;
        description = descr;
        this.price = price;
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return id + ": " + description + ", price: $" + price;
    }

    public void priceChange(double change) {
        price += change;
    }

    public static Generator<Product> generator = new Generator<Product>() {
        private Random rand = new Random(47);

        @Override
        public Product next() {
            return new Product(rand.nextInt(1000), "Test", Math.round(rand.nextDouble() * 1000.0) + 0.99);
        }
    };
}

class Container extends ArrayList<Product> {
    public Container(int nProducts) {
        Generators.fill(this, Product.generator, nProducts);
    }
}

class CargoHold extends ArrayList<Container> {
    public CargoHold(int nContainers, int nProducts) {
        for (int i = 0; i < nContainers; i++)
            add(new Container(nProducts));
    }
}

class Crane {
}

class CommandSection {
}

class CargoShip extends ArrayList<CargoHold> {
    private ArrayList<Crane> cranes     = new ArrayList<Crane>();
    private CommandSection   cmdSection = new CommandSection();

    public CargoShip(int nCargoHolds, int nContainers, int nProducts) {
        for (int i = 0; i < nCargoHolds; i++)
            add(new CargoHold(nContainers, nProducts));
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (CargoHold ch : this)
            for (Container c : ch)
                for (Product p : c) {
                    result.append(p);
                    result.append("\n");
                }
        return result.toString();
    }
}

public class E19_CargoShip {
    public static void main(String[] args) {
        System.out.println(new CargoShip(14, 5, 10));
    }
}
