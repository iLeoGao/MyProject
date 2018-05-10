package com.leogao.learn.thinkinjava.generics.exercise;

interface Payable {
}

class Employee implements Payable {
}

class Hourly extends Employee implements Payable {
}

public class E31_MultipleInterfaceVariants2 {
    public static void main(String[] args) {
        new Employee();
        new Hourly();
    }
}
