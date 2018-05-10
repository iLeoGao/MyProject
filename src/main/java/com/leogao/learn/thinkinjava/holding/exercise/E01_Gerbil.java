package com.leogao.learn.thinkinjava.holding.exercise;

import java.util.ArrayList;

class Gerbil {
    private final int gerbilNumber;

    Gerbil(int gerbilNumber) {
        this.gerbilNumber = gerbilNumber;
    }

    @Override
    public String toString() {
        return "gerbil " + gerbilNumber;
    }

    public void hop() {
        System.out.println(this + " is hopping");
    }
}

public class E01_Gerbil {
    public static void main(String args[]) {
        ArrayList<Gerbil> gerbils = new ArrayList<Gerbil>();
        for (int i = 0; i < 10; i++)
            gerbils.add(new Gerbil(i));
        for (int i = 0; i < gerbils.size(); i++)
            gerbils.get(i).hop();
    }
} /*
   * Output: gerbil 0 is hopping gerbil 1 is hopping gerbil 2 is hopping gerbil
   * 4 is hopping gerbil 5 is hopping gerbil 6 is hopping gerbil 7 is hopping
   * gerbil 8 is hopping gerbil 9 is hopping
   *///:~
