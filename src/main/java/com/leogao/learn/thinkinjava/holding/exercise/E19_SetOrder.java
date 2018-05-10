package com.leogao.learn.thinkinjava.holding.exercise;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import com.leogao.learn.thinkinjava.net.mindview.util.Countries;

public class E19_SetOrder {
    public static void main(String[] args) {
        Set<String> s1 = new HashSet<String>(Countries.names(25));
        System.out.println(s1);
        String[] elements = s1.toArray(new String[0]);
        Arrays.sort(elements);
        Set<String> s2 = new LinkedHashSet<String>();
        for (String element : elements)
            s2.add(element);
        System.out.println(s2);
    }
} /*
   * Output: [KENYA, THE GAMBIA, CHAD, CAPE VERDE, COTE D'IVOIR (IVORY COAST),
   * GUINEA, COMOROS, CAMEROON, ANGOLA, EGYPT, BURKINA FASO, BENIN, BURUNDI,
   * ETHIOPIA, BOTSWANA, DJIBOUTI, CONGO, CENTRAL AFRICAN REPUBLIC, ERITREA,
   * ALGERIA, EQUATORIAL GUINEA, GHANA, GABON, BISSAU, LESOTHO] [ALGERIA,
   * ANGOLA, BENIN, BISSAU, BOTSWANA, BURKINA FASO, BURUNDI, CAMEROON, CAPE
   * VERDE, CENTRAL AFRICAN REPUBLIC, CHAD, COMOROS, CONGO, COTE D'IVOIR (IVORY
   * COAST), DJIBOUTI, EGYPT, EQUATORIAL GUINEA, ERITREA, ETHIOPIA, GABON,
   * GHANA, GUINEA, KENYA, LESOTHO, THE GAMBIA]
   *///:~
