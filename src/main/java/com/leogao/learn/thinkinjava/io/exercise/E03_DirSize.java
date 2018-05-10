package com.leogao.learn.thinkinjava.io.exercise;

import static com.leogao.learn.thinkinjava.net.mindview.util.Print.print;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class E03_DirSize {
    public static void main(final String[] args) {
        File path = new File(".");
        String[] list;
        if (args.length == 0)
            list = path.list();
        else
            list = path.list(new FilenameFilter() {
                private Pattern pattern = Pattern.compile(args[0]);

                @Override
                public boolean accept(File dir, String name) {
                    return pattern.matcher(name).matches();
                }
            });
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        long total = 0;
        long fs;
        for (String dirItem : list) {
            fs = new File(path, dirItem).length();
            print(dirItem + ", " + fs + " byte(s)");
            total += fs;
        }
        print("=======================");
        print(list.length + " file(s), " + total + " bytes");
    }
}
