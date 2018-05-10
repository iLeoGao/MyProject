package com.leogao.learn.thinkinjava.io.exercise;

import java.io.File;

import com.leogao.learn.thinkinjava.net.mindview.util.Directory;

public class E04_DirSize2 {
    public static void main(String[] args) {
        Directory.TreeInfo ti;
        if (args.length == 0)
            ti = Directory.walk("../object");
        else
            ti = Directory.walk("../object", args[0]);
        long total = 0;
        for (File file : ti)
            total += file.length();
        System.out.println(ti.files.size() + " file(s), " + total + " bytes");
    }
}
