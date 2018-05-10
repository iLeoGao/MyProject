package com.leogao.learn.thinkinjava.holding.exercise;

import static com.leogao.learn.thinkinjava.net.mindview.util.Print.print;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

class Rodent {
    public void hop() {
        print("Rodent hopping");
    }

    public void scurry() {
        print("Rodent scurrying");
    }

    public void reproduce() {
        print("Making more Rodents");
    }

    @Override
    public String toString() {
        return "Rodent";
    }
}

class Mouse extends Rodent {
    @Override
    public void hop() {
        print("Mouse hopping");
    }

    @Override
    public void scurry() {
        print("Mouse scurrying");
    }

    @Override
    public void reproduce() {
        print("Making more Mice");
    }

    @Override
    public String toString() {
        return "Mouse";
    }
}

class Hamster extends Rodent {
    @Override
    public void hop() {
        print("Hamster hopping");
    }

    @Override
    public void scurry() {
        print("Hamster scurrying");
    }

    @Override
    public void reproduce() {
        print("Making more Hamsters");
    }

    @Override
    public String toString() {
        return "Hamster";
    }
}

public class E10_RodentIterator {
    public static void main(String args[]) {
        ArrayList<Rodent> rodents = new ArrayList<Rodent>(Arrays.asList(new Rodent(), new Mouse(), new Hamster()));
        Rodent r;
        for (Iterator<Rodent> it = rodents.iterator(); it.hasNext();) {
            r = it.next();
            r.hop();
            r.scurry();
            r.reproduce();
            print(r);
        }
    }
} /*
   * Output: Rodent hopping Rodent scurrying Making more Rodents Rodent Mouse
   * hopping Mouse scurrying Making more Mice Mouse Hamster hopping Hamster
   * scurrying Making more Hamsters Hamster
   *///:~
