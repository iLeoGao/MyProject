package com.leogao.learn.thinkinjava.generics;

import java.util.List;
import java.util.Map;

import com.leogao.learn.thinkinjava.net.mindview.util.New;
import com.leogao.learn.thinkinjava.typeinfo.pets.Person;
import com.leogao.learn.thinkinjava.typeinfo.pets.Pet;

public class ExplicitTypeSpecification {
    static void f(Map<Person, List<Pet>> petPeople) {
    }

    public static void main(String[] args) {
        f(New.<Person, List<Pet>> map());
    }
} ///:~
