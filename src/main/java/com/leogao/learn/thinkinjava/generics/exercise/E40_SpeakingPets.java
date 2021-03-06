package com.leogao.learn.thinkinjava.generics.exercise;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import com.leogao.learn.thinkinjava.typeinfo.pets.Individual;

class SPet extends Individual {
    public SPet(String name) {
        super(name);
    }

    public SPet() {
        super();
    }

    public void speak() {
        System.out.println(this + " speak");
    }
}

class SRodent extends SPet {
    public SRodent(String name) {
        super(name);
    }

    public SRodent() {
        super();
    }
}

class SRat extends SRodent {
    public SRat(String name) {
        super(name);
    }

    public SRat() {
        super();
    }
}

class SPug extends SDog {
    public SPug(String name) {
        super(name);
    }

    public SPug() {
        super();
    }
}

class SMutt extends SDog {
    public SMutt(String name) {
        super(name);
    }

    public SMutt() {
        super();
    }
}

class SMouse extends SRodent {
    public SMouse(String name) {
        super(name);
    }

    public SMouse() {
        super();
    }
}

class SManx extends SCat {
    public SManx(String name) {
        super(name);
    }

    public SManx() {
        super();
    }
}

class SHamster extends SRodent {
    public SHamster(String name) {
        super(name);
    }

    public SHamster() {
        super();
    }
}

class SEgyptianMau extends SCat {
    public SEgyptianMau(String name) {
        super(name);
    }

    public SEgyptianMau() {
        super();
    }
}

class SDog extends SPet {
    public SDog(String name) {
        super(name);
    }

    public SDog() {
        super();
    }
}

class SCymric extends SManx {
    public SCymric(String name) {
        super(name);
    }

    public SCymric() {
        super();
    }
}

class SCat extends SPet {
    public SCat(String name) {
        super(name);
    }

    public SCat() {
        super();
    }
}

public class E40_SpeakingPets {
    public static void main(String[] args) throws Exception {
        List<SPet> pets = Arrays.asList(new SRat(), new SPug(), new SMutt(), new SMouse(), new SManx(), new SHamster(),
                new SEgyptianMau(), new SCymric());
        Apply40.apply(pets, SPet.class.getMethod("speak"));
    }
}

class Apply40 {
    public static <T, S extends Iterable<? extends T>> void apply(S seq, Method f, Object... args) {
        try {
            for (T t : seq)
                f.invoke(t, args);
        } catch (Exception e) {
            // Failures are programmer errors
            throw new RuntimeException(e);
        }
    }
}/*
  * Output: SRat speak SPug speak SMutt speak SMouse speak SManx speak SHamster
  * speak SEgyptianMau speak SCymric speak
  *///:~
