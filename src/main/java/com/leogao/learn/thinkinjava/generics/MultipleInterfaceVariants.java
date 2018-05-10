package com.leogao.learn.thinkinjava.generics;

// {CompileTimeError} (Won't compile)

interface Payable<T> {
}

class Employee implements Payable<Employee> {
}

class Hourly extends Employee {
}

//class Hourly extends Employee implements Payable<Hourly> {
//} ///:~
