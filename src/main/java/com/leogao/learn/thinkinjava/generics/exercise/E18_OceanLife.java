package com.leogao.learn.thinkinjava.generics.exercise;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import com.leogao.learn.thinkinjava.generics.Generators;
import com.leogao.learn.thinkinjava.net.mindview.util.Generator;

class LittleFish {
    private static long counter = 1;
    private final long  id      = counter++;

    private LittleFish() {

    }

    @Override
    public String toString() {
        return "LittleFish " + id;
    }

    public static Generator<LittleFish> generator() {
        return new Generator<LittleFish>() {
            @Override
            public LittleFish next() {
                return new LittleFish();
            }
        };
    }
}

class BigFish {
    private static long counter = 1;
    private final long  id      = counter++;

    private BigFish() {

    }

    @Override
    public String toString() {
        return "BigFish " + id;
    }

    public static Generator<BigFish> generator = new Generator<BigFish>() {
        @Override
        public BigFish next() {
            return new BigFish();
        }
    };
}

public class E18_OceanLife {
    public static void eat(BigFish bf, LittleFish lf) {
        System.out.println(bf + " eat " + lf);
    }

    public static void main(String[] args) {
        Random rand = new Random(47);
        List<LittleFish> littleF = new LinkedList<LittleFish>();
        Generators.fill(littleF, LittleFish.generator(), 15);
        List<BigFish> bigF = new ArrayList<BigFish>();
        Generators.fill(bigF, BigFish.generator, 4);
        for (LittleFish lf : littleF)
            eat(bigF.get(rand.nextInt(bigF.size())), lf);
    }
}/*
  * OutPut: BigFish 3 eat LittleFish 1 BigFish 2 eat LittleFish 2 BigFish 3 eat
  * LittleFish 3 BigFish 1 eat LittleFish 4 BigFish 1 eat LittleFish 5 BigFish 3
  * eat LittleFish 6 BigFish 1 eat LittleFish 7 BigFish 2 eat LittleFish 8
  * BigFish 3 eat LittleFish 9 BigFish 3 eat LittleFish 10 BigFish 2 eat
  * LittleFish 11 BigFish 4 eat LittleFish 12 BigFish 2 eat LittleFish 13
  * BigFish 1 eat LittleFish 14 BigFish 1 eat LittleFish 15
  */
