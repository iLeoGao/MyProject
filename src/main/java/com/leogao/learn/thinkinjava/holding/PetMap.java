package com.leogao.learn.thinkinjava.holding;

import static com.leogao.learn.thinkinjava.net.mindview.util.Print.print;

import java.util.HashMap;
import java.util.Map;

import com.leogao.learn.thinkinjava.typeinfo.pets.Cat;
import com.leogao.learn.thinkinjava.typeinfo.pets.Dog;
import com.leogao.learn.thinkinjava.typeinfo.pets.Hamster;
import com.leogao.learn.thinkinjava.typeinfo.pets.Pet;

public class PetMap {
    public static void main(String[] args) {
        Map<String, Pet> petMap = new HashMap<String, Pet>();
        petMap.put("My Cat", new Cat("Molly"));
        petMap.put("My Dog", new Dog("Ginger"));
        petMap.put("My Hamster", new Hamster("Bosco"));
        print(petMap);
        Pet dog = petMap.get("My Dog");
        print(dog);
        print(petMap.containsKey("My Dog"));
        print(petMap.containsValue(dog));
    }
} /*
   * Output: {My Cat=Cat Molly, My Hamster=Hamster Bosco, My Dog=Dog Ginger} Dog
   * Ginger true true
   *///:~
