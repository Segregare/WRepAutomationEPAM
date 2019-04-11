package com.company.Collections;


import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Stack;

public class OptionalTaskTwo {
    public static void main(String[] args) {
        Scanner scnanner = new Scanner(System.in);
        int a = 0;
        System.out.print("Введите число: ");
        try {
            a = scnanner.nextInt();
        }catch (InputMismatchException e){
            System.out.println("Вы ввели не число!");
        }

        Stack<Integer> stack = new Stack<>();
        while (a != 0) {
            stack.add(a % 10);
            a /= 10;
        }
        System.out.print("Полученный стек: " + stack);

        Collections.reverse(stack);

        System.out.print("Полученное число: ");
        while (!stack.empty()) {
            int reverseNumber;
            reverseNumber = stack.pop();
            System.out.print(reverseNumber);
        }

    }
}
