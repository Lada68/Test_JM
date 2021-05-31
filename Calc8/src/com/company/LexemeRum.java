package com.company;

import java.util.HashMap;
import java.util.Map;

public class LexemeRum {
    public static Map<String, Integer> lexemeRum = new HashMap<String, Integer>();

    public LexemeRum(HashMap<String, Integer> lexemeRum) {
        this.lexemeRum = lexemeRum;
    }

    public static void met(HashMap<String, Integer> lexemeRum) {

        lexemeRum.put("I", 1);
        lexemeRum.put("II", 2);
        lexemeRum.put("III", 3);
        lexemeRum.put("IV", 4);
        lexemeRum.put("V", 5);
        lexemeRum.put("VI", 6);
        lexemeRum.put("VII", 7);
        lexemeRum.put("VIII", 8);
        lexemeRum.put("IX", 9);
        lexemeRum.put("X", 10);
    }


}
