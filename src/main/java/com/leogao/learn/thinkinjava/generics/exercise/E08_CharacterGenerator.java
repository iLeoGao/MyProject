package com.leogao.learn.thinkinjava.generics.exercise;

import java.util.Iterator;
import java.util.Random;

import com.leogao.learn.thinkinjava.net.mindview.util.Generator;

class StoryCharacter {
    private static long counter;
    private final long  id = counter++;

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + id;
    }
}

class GoodGuy extends StoryCharacter {
    @Override
    public String toString() {
        return super.toString() + " is a good guy";
    }
}

class BadGuy extends StoryCharacter {
    @Override
    public String toString() {
        return super.toString() + " is a bad guy";
    }
}

class Morton extends BadGuy {
}

class Frank extends BadGuy {
}

class Harmonica extends GoodGuy {
}

class Cheyenne extends GoodGuy {
}

class CharacterGenerator implements Generator<StoryCharacter>, Iterable<StoryCharacter> {
    private Class<?>[]    types = { Morton.class, Frank.class, Harmonica.class, Cheyenne.class };
    private static Random rand  = new Random(47);

    public CharacterGenerator() {
    }

    private int size = 0;

    public CharacterGenerator(int sz) {
        size = sz;
    }

    @Override
    public StoryCharacter next() {
        try {
            return (StoryCharacter) types[rand.nextInt(types.length)].newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    class CharacterIterator implements Iterator<StoryCharacter> {
        int count = size;

        @Override
        public boolean hasNext() {
            return count > 0;
        }

        @Override
        public StoryCharacter next() {
            count--;
            return CharacterGenerator.this.next();
        }

        @Override
        public void remove() { // Not implemented
            throw new UnsupportedOperationException();
        }
    };

    @Override
    public Iterator<StoryCharacter> iterator() {
        return new CharacterIterator();
    }
}

public class E08_CharacterGenerator {
    public static void main(String[] args) {
        CharacterGenerator gen = new CharacterGenerator();
        for (int i = 0; i < 7; i++) {
            System.out.println(gen.next());
        }

        for (StoryCharacter p : new CharacterGenerator(7)) {
            System.out.println(p);
        }
    }
}
/*
 * OutPut: Harmonica 0 is a good guy Frank 1 is a bad guy Harmonica 2 is a good
 * guy Morton 3 is a bad guy Morton 4 is a bad guy Harmonica 5 is a good guy
 * Morton 6 is a bad guy Frank 7 is a bad guy Harmonica 8 is a good guy
 * Harmonica 9 is a good guy Frank 10 is a bad guy Cheyenne 11 is a good guy
 * Frank 12 is a bad guy Morton 13 is a bad guy
 */
