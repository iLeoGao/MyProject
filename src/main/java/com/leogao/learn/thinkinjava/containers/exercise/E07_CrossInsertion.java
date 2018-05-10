package com.leogao.learn.thinkinjava.containers.exercise;

import static com.leogao.learn.thinkinjava.net.mindview.util.Print.print;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

import com.leogao.learn.thinkinjava.net.mindview.util.Countries;

public class E07_CrossInsertion {
    public static void main(String args[]) {
        ArrayList<String> al = new ArrayList<String>(Countries.names(10));
        LinkedList<String> ll = new LinkedList<String>(Countries.names(20).subList(10, 20));
        for (Iterator<String> it = al.iterator(); it.hasNext();)
            print(it.next());
        print("********");
        for (Iterator<String> it = ll.iterator(); it.hasNext();)
            print(it.next());
        print("********");
        int alindex = 0;
        for (ListIterator<String> lit2 = ll.listIterator(); lit2.hasNext();) {
            al.add(alindex, lit2.next());
            alindex += 2;
        }
        print("al = " + al);
        print("********");
        alindex = 0;
        // Start at the end:
        for (ListIterator<String> lit2 = ll.listIterator(ll.size()); lit2.hasPrevious();) {
            al.add(alindex, lit2.previous());
            alindex += 2;
        }
        print("al = " + al);
    }
}
