package com.leogao.learn.thinkinjava.generics;

// {CompileTimeError} (Won't compile)

class Cat extends ComparablePet {
    // class Cat extends ComparablePet implements Comparable<Cat> {
    // Error: Comparable cannot be inherited with
    // different arguments: <Cat> and <Pet>
    public int compareTo(Cat arg) {
        return 0;
    }
} ///:~
