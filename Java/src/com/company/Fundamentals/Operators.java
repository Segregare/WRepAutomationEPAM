package com.company.Fundamentals;

import java.util.Scanner;

public class Operators {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите число K: ");
        int numberK = scan.nextInt();
        System.out.print("Введите число N: ");
        int numberN = scan.nextInt();
        System.out.print("Введите число M: ");
        int numberM = scan.nextInt();

        if (numberN < numberK && numberK <= numberM) {
            System.out.println("numberК принадлежит интервалу (numberN, numberM]");
        } else if (numberN <= numberK && numberK < numberM) {
            System.out.println("numberК принадлежит интервалу [numberN, numberM)");
        } else if (numberN < numberK && numberK < numberM) {
            System.out.println("numberК принадлежит интервалу (numberN, numberM)");
        } else if (numberN <= numberK && numberK <= numberM) {
            System.out.println("numberК принадлежит интервалу [numberN, numberM]");
        } else {
            System.out.println("ОТВЕТ: numberK не принадлежит заданным интервалам");
        }
    }
}
