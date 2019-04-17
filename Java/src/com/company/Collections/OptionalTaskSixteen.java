package com.company.Collections;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class OptionalTaskSixteen {
    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("C:\\Users\\Богдан\\Desktop\\sixteen.txt");
        Scanner scanner = new Scanner(file);;
        List<String> list = new ArrayList<String>();

            while (scanner.hasNextLine()) {
                list.add(scanner.nextLine());
            }


        System.out.println(list);

        String text[] = new String[list.size()];
        int i = 0;
        for (String string : list) {
            text[i] = string.toLowerCase();
            i++;
        }

        HashSet<String> hashSet = new HashSet<String>(Arrays.asList(text));
        System.out.println(hashSet);

    }
}
