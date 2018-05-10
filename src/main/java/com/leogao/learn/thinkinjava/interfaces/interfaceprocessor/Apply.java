package com.leogao.learn.thinkinjava.interfaces.interfaceprocessor;

import static com.leogao.learn.thinkinjava.net.mindview.util.Print.print;

public class Apply {
    public static void process(Processor p, Object s) {
        print("Using Processor " + p.name());
        print(p.process(s));
    }
} ///:~
