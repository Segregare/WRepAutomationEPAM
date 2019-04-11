package com.company.Collections;

import java.util.ArrayList;

public class MainTaskSecond {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        int size = 10;
        int y = 5;
        for(int i = 0; i < size; i++){
            list.add(i + 1);
        }
        System.out.println(list);

        for (int i=0;i<size-1;i++) {
            for (int j = 0; j < size - 1; j++)
                if (list.get(j) > y) {
                    list.set(j + 1, list.get(j + 1) + list.get(j));
                    list.set(j, list.get(j + 1) - list.get(j));
                    list.set(j + 1, list.get(j + 1) - list.get(j));
                }
        }
        System.out.println(list);
    }
}
