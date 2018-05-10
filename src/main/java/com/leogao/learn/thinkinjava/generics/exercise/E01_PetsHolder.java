package com.leogao.learn.thinkinjava.generics.exercise;

import com.leogao.learn.thinkinjava.generics.Holder3;
import com.leogao.learn.thinkinjava.typeinfo.pets.Mouse;
import com.leogao.learn.thinkinjava.typeinfo.pets.Pet;

public class E01_PetsHolder {
    public static void main(String[] args) {
        Holder3<Pet> h3 = new Holder3<Pet>(new Mouse("Mickey"));
        System.out.println(h3.get());
    }
}
