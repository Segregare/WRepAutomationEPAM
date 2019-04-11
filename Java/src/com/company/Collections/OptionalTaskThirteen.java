package com.company.Collections;

import java.util.ArrayList;

public class OptionalTaskThirteen {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        int size = 10;
        for (int i = 0; i < size; i++) {
            int a = (int) (Math.random() * (10 - (-10)) - 10);
            list.add(a);
        }
        System.out.println(list);

        int reverse = 0;
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1; j++)
                if(list.get(i) < 0)
                {
                    list.add(list.get(i));
                    list.remove(list.get(i));
                    reverse++;
                }
                else
                    i++;
        }
        System.out.println(list);
    }
}
