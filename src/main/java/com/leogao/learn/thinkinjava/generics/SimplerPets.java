package com.leogao.learn.thinkinjava.generics;

import java.util.List;
import java.util.Map;

import com.leogao.learn.thinkinjava.net.mindview.util.New;
import com.leogao.learn.thinkinjava.typeinfo.pets.Person;
import com.leogao.learn.thinkinjava.typeinfo.pets.Pet;

public class SimplerPets {
    public static void main(String[] args) {
        Map<Person, List<? extends Pet>> petPeople = New.map();
        // Rest of the code is the same...
    }
} ///:~
