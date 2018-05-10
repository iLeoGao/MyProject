package com.leogao.learn.thinkinjava.generics;

import java.util.List;
import java.util.Map;

import com.leogao.learn.thinkinjava.typeinfo.pets.Person;
import com.leogao.learn.thinkinjava.typeinfo.pets.Pet;

public class LimitsOfInference {
    static void f(Map<Person, List<? extends Pet>> petPeople) {
    }

    public static void main(String[] args) {
        //f(New.map()); // Does not compile
    }
} ///:~
