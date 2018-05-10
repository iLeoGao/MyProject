package com.leogao.learn.thinkinjava.generics.exercise;

import static com.leogao.learn.thinkinjava.net.mindview.util.Print.print;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.leogao.learn.thinkinjava.generics.SimpleQueue;
import com.leogao.learn.thinkinjava.net.mindview.util.Generator;
import com.leogao.learn.thinkinjava.typeinfo.pets.Cymric;
import com.leogao.learn.thinkinjava.typeinfo.pets.Mouse;
import com.leogao.learn.thinkinjava.typeinfo.pets.Mutt;
import com.leogao.learn.thinkinjava.typeinfo.pets.Pet;

interface Addable<T> {
    void add(T t);
}

class Adapter {
    public static <T> Addable<T> collectionAdapter(Collection<T> c) {
        return new AddableCollectionAdapter<T>(c);
    }
}

// To adapt a specific type, you can use inheritance.
// Make a SimpleQueue Addable using inheritance:
class AddableSimpleQueue<T> extends SimpleQueue<T> implements Addable<T> {
    @Override
    public void add(T item) {
        super.add(item);
    }
}

class AddableCollectionAdapter<T> implements Addable<T> {
    private Collection<T> c;

    public AddableCollectionAdapter(Collection<T> c) {
        this.c = c;
    }

    @Override
    public void add(T item) {
        c.add(item);
    }
}

class Fill3 {
    // Classtoken version:
    public static <T> void fill(Addable<T> addable, Class<? extends T> classToken, int size) {
        for (int i = 0; i < size; i++)
            try {
                addable.add(classToken.newInstance());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
    }

    // Generator version:
    public static <T> void fill(Addable<T> addable, Generator<T> generator, int size) {
        for (int i = 0; i < size; i++)
            addable.add(generator.next());
    }
}

public class E41_Fill3 {
    public static void main(String[] args) throws Exception {
        // Adapt a Collection:
        List<Pet> carrier = new ArrayList<Pet>();
        Fill3.fill(new AddableCollectionAdapter<Pet>(carrier), Pet.class, 3);
        // Helper method captures the type:
        Fill3.fill(Adapter.collectionAdapter(carrier), Mouse.class, 2);
        for (Pet p : carrier)
            print(p);
        print("----------------------");
        // Use an adapted class:
        AddableSimpleQueue<Pet> petQueue = new AddableSimpleQueue<Pet>();
        Fill3.fill(petQueue, Mutt.class, 4);
        Fill3.fill(petQueue, Cymric.class, 1);
        for (Pet p : petQueue)
            print(p);
    }
} /*
   * Output: Pet Pet Pet Mouse Mouse ---------------------- Mutt Mutt Mutt Mutt
   * Cymric
   *///:~
