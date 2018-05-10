//: holding/MapOfList.java
package com.leogao.learn.thinkinjava.holding;

import static com.leogao.learn.thinkinjava.net.mindview.util.Print.print;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.leogao.learn.thinkinjava.typeinfo.pets.Cat;
import com.leogao.learn.thinkinjava.typeinfo.pets.Cymric;
import com.leogao.learn.thinkinjava.typeinfo.pets.Dog;
import com.leogao.learn.thinkinjava.typeinfo.pets.Mutt;
import com.leogao.learn.thinkinjava.typeinfo.pets.Person;
import com.leogao.learn.thinkinjava.typeinfo.pets.Pet;
import com.leogao.learn.thinkinjava.typeinfo.pets.Pug;
import com.leogao.learn.thinkinjava.typeinfo.pets.Rat;

public class MapOfList {
    public static Map<Person, List<? extends Pet>> petPeople = new HashMap<Person, List<? extends Pet>>();
    static {
        petPeople.put(new Person("Dawn"), Arrays.asList(new Cymric("Molly"), new Mutt("Spot")));
        petPeople.put(new Person("Kate"),
                Arrays.asList(new Cat("Shackleton"), new Cat("Elsie May"), new Dog("Margrett")));
        petPeople.put(new Person("Marilyn"), Arrays.asList(new Pug("Louie aka Louis Snorkelstein Dupree"),
                new Cat("Stanford aka Stinky el Negro"), new Cat("Pinkola")));
        petPeople.put(new Person("Luke"), Arrays.asList(new Rat("Fuzzy"), new Rat("Fizzy")));
        petPeople.put(new Person("Isaac"), Arrays.asList(new Rat("Freckly")));
    }

    public static void main(String[] args) {
        print("People: " + petPeople.keySet());
        print("Pets: " + petPeople.values());
        for (Person person : petPeople.keySet()) {
            print(person + " has:");
            for (Pet pet : petPeople.get(person))
                print("    " + pet);
        }
    }
} /*
   * Output: People: [Person Marilyn, Person Dawn, Person Luke, Person Isaac,
   * Person Kate] Pets: [[Pug Louie aka Louis Snorkelstein Dupree, Cat Stanford
   * aka Stinky el Negro, Cat Pinkola], [Cymric Molly, Mutt Spot], [Rat Fuzzy,
   * Rat Fizzy], [Rat Freckly], [Cat Shackleton, Cat Elsie May, Dog Margrett]]
   * Person Marilyn has: Pug Louie aka Louis Snorkelstein Dupree Cat Stanford
   * aka Stinky el Negro Cat Pinkola Person Dawn has: Cymric Molly Mutt Spot
   * Person Luke has: Rat Fuzzy Rat Fizzy Person Isaac has: Rat Freckly Person
   * Kate has: Cat Shackleton Cat Elsie May Dog Margrett
   *///:~
