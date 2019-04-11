package com.company.Collections;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class OptionalTaskOne {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("C:\\Users\\Богдан\\Desktop\\collections.txt");
        Scanner scanner = new Scanner(file);
        ArrayList<String> list = new ArrayList<>();
        while (scanner.hasNextLine()) {
            list.add(scanner.nextLine());
        }
        System.out.println(list);
        Collections.reverse(list);
        PrintWriter writer = new PrintWriter("C:\\Users\\Богдан\\Desktop\\collections.txt");


        for(int i = 0; i < list.size(); i++){
            writer.println(list.get(i));
        }

        writer.println("\nФайл был перезаписан");
        writer.close();

    }
}
