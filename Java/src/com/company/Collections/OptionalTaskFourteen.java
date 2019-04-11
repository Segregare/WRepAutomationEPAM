package com.company.Collections;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class OptionalTaskFourteen {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("C:\\Users\\Богдан\\Desktop\\sort.txt");
        Scanner scanner = new Scanner(file);
        OptionalTaskSix.LengthSort sort = new OptionalTaskSix.LengthSort();
        List<String> list = new ArrayList<>();
        while (scanner.hasNextLine()) {
            list.add(scanner.nextLine());
        }
        System.out.println(list);

        Collections.sort(list, sort);
        System.out.println();
        System.out.println(list);
    }

    static class LengthSort implements Comparator<String> {


        public int compare(String s1, String s2) {
            return s1.length() - s2.length();
        }
    }
}
