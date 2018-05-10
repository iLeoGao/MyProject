package com.leogao.learn.thinkinjava.holding.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import com.leogao.learn.thinkinjava.typeinfo.pets.Pet;

class NonCollectionSequence extends PetSequence implements Iterable<Pet> {
    public Iterable<Pet> reversed() {
        return new Iterable<Pet>() {
            @Override
            public Iterator<Pet> iterator() {
                return new Iterator<Pet>() {
                    int current = pets.length - 1;

                    @Override
                    public boolean hasNext() {
                        return current > -1;
                    }

                    @Override
                    public Pet next() {
                        return pets[current--];
                    }

                    @Override
                    public void remove() { // Not implemented
                        throw new UnsupportedOperationException();
                    }
                };
            }
        };
    }

    public Iterable<Pet> randomized() {
        return new Iterable<Pet>() {
            @Override
            public Iterator<Pet> iterator() {
                List<Pet> shuffled = new ArrayList<Pet>(Arrays.asList(pets));
                Collections.shuffle(shuffled, new Random(47));
                return shuffled.iterator();
            }
        };
    }

    @Override
    public Iterator<Pet> iterator() {
        return new Iterator<Pet>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < pets.length;
            }

            @Override
            public Pet next() {
                return pets[index++];
            }

            @Override
            public void remove() { // Not implemented
                throw new UnsupportedOperationException();
            }
        };
    }
}

public class E32_MultiIterableNonCollectionSeq {
    public static void main(String[] args) {
        NonCollectionSequence nc = new NonCollectionSequence();
        for (Pet pet : nc.reversed())
            System.out.print(pet + " ");
        System.out.println();
        for (Pet pet : nc.randomized())
            System.out.print(pet + " ");
        System.out.println();
        for (Pet pet : nc)
            System.out.print(pet + " ");
    }
}
