package com.company.Exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args){
        try {
            File f = new File("C:\\Users\\Богдан\\Desktop\\notes.txt");
            Scanner sc = new Scanner(f);
            String line = sc.nextLine();

            String[] numbersString = line.split(" ");
            float result;
            float sum = 0;
            float average = 0;
            int counter = 0;
            for(String number : numbersString)
            try {
                 {
                    result = Float.parseFloat(number);
                     counter++;
                     if (counter == 0){
                         throw new NoComputingException(counter);
                     }
                    System.out.print(result + " ");
                    sum += result;
                }

            } catch (NumberFormatException exc){
            }
            average = sum / counter;
            System.out.println();
            System.out.println("Сумма чисел: " + sum);
            System.out.println("Среднее значение: " + average);
        } catch (FileNotFoundException exc) {
            System.out.println("Файл не найден");
        } catch (NoSuchElementException exc) {
            System.out.println("К сожалению, файл пуст");
        } catch (NoComputingException exc){
            System.out.println(exc);
        } catch (ArithmeticException exc) {
            System.out.println("Попытка деления на ноль");
        }
    }
}



