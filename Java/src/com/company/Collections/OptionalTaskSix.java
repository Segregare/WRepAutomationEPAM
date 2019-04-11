package com.company.Collections;

import java.util.*;


public class OptionalTaskSix {
    public static void main(String[] args) {
        List<String> poem = new ArrayList<>();
        LengthSort sort = new LengthSort();
        poem.add("Маленький краб");
        poem.add("побежал по ноге.");
        poem.add("Чистая вода.");
        System.out.println("До сортировки: " + poem);
        System.out.println();

        Collections.sort(poem, sort);
        System.out.println("После сортировки: " + poem);

    }


    static class LengthSort implements Comparator<String> {


        public int compare(String s1, String s2) {
            return s1.length() - s2.length();
        }
    }
}
