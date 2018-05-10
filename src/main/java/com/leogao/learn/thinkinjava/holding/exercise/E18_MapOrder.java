package com.leogao.learn.thinkinjava.holding.exercise;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.leogao.learn.thinkinjava.net.mindview.util.Countries;

public class E18_MapOrder {
    public static void main(String[] args) {
        Map<String, String> m1 = new HashMap<String, String>(Countries.capitals(25));
        System.out.println(m1);
        String[] keys = m1.keySet().toArray(new String[0]);
        Arrays.sort(keys);
        Map<String, String> m2 = new LinkedHashMap<String, String>();
        for (String key : keys)
            m2.put(key, m1.get(key));
        System.out.println(m2);
    }
} /*
   * Output: {KENYA=Nairobi, THE GAMBIA=Banjul, CHAD=N'djamena, CAPE
   * VERDE=Praia, COTE D'IVOIR (IVORY COAST)=Yamoussoukro, GUINEA=Conakry,
   * COMOROS=Moroni, CAMEROON=Yaounde, ANGOLA=Luanda, EGYPT=Cairo, BURKINA
   * FASO=Ouagadougou, BENIN=Porto-Novo, BURUNDI=Bujumbura, ETHIOPIA=Addis
   * Ababa, BOTSWANA=Gaberone, DJIBOUTI=Dijibouti, CONGO=Brazzaville, CENTRAL
   * AFRICAN REPUBLIC=Bangui, ERITREA=Asmara, ALGERIA=Algiers, EQUATORIAL
   * GUINEA=Malabo, GHANA=Accra, GABON=Libreville, BISSAU=Bissau,
   * LESOTHO=Maseru} {ALGERIA=Algiers, ANGOLA=Luanda, BENIN=Porto-Novo,
   * BISSAU=Bissau, BOTSWANA=Gaberone, BURKINA FASO=Ouagadougou,
   * BURUNDI=Bujumbura, CAMEROON=Yaounde, CAPE VERDE=Praia, CENTRAL AFRICAN
   * REPUBLIC=Bangui, CHAD=N'djamena, COMOROS=Moroni, CONGO=Brazzaville, COTE
   * D'IVOIR (IVORY COAST)=Yamoussoukro, DJIBOUTI=Dijibouti, EGYPT=Cairo,
   * EQUATORIAL GUINEA=Malabo, ERITREA=Asmara, ETHIOPIA=Addis Ababa,
   * GABON=Libreville, GHANA=Accra, GUINEA=Conakry, KENYA=Nairobi,
   * LESOTHO=Maseru, THE GAMBIA=Banjul}
   *///:~
