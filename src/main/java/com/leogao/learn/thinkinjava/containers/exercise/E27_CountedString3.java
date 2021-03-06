package com.leogao.learn.thinkinjava.containers.exercise;

import static com.leogao.learn.thinkinjava.net.mindview.util.Print.print;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class CountedString3 {
    private static List<String> created = new ArrayList<String>();
    private String              s;
    private int                 id      = 0;

    public CountedString3(String str) {
        s = str;
        created.add(s);
        // id is the total number of instances
        // of this string in use by CountedString3:
        for (String s2 : created)
            if (s2.equals(s))
                id++;
    }

    @Override
    public String toString() {
        return "String: " + s + " id: " + id + " hashCode(): " + hashCode();
    }

    @Override
    public int hashCode() {
        // The very simple approach:
        // return s.hashCode();
        // Using Joshua Bloch's recipe:
        int result = 17;
        result = 37 * result + s.hashCode();
        // result = 37 * result + id;
        return result;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof CountedString3 && s.equals(((CountedString3) o).s) && id == ((CountedString3) o).id;
    }
}

public class E27_CountedString3 {
    public static void main(String[] args) {
        Map<CountedString3, Integer> map = new HashMap<CountedString3, Integer>();
        CountedString3[] cs = new CountedString3[5];
        for (int i = 0; i < cs.length; i++) {
            cs[i] = new CountedString3("hi");
            map.put(cs[i], i); // Autobox int -> Integer
        }
        for (CountedString3 cstring : cs) {
            print("Looking up " + cstring);
            print(map.get(cstring));
        }
    }
}
