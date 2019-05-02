package company.Fundamentals;

import java.util.Scanner;

public class Datatypes {
    public static void main(String[] args) {
        System.out.println("Введите число элементов:");
        Scanner scan = new Scanner(System.in);
        int numberOfElements = scan.nextInt();
        int massiv[] = new int[numberOfElements];
        int numbers[] = new int[numberOfElements];
        System.out.println("Введите ваши числа через пробел:");
        for (int i = 0; i < numberOfElements; i++) {
            massiv[i] = scan.nextInt();
            numbers[i] = (massiv[i] + "").length();
        }

        lengthOfNumbers(massiv, numbers, numberOfElements);
    }
    private static void lengthOfNumbers(int[] massiv, int[] numbers, int numberOfElements) {
        int max = numbers[0];
        int min = numbers[0];
        int longest = 0;
        int shortest = 0;
        for (int i = 1; i < numberOfElements; i++) {
            int j = numbers[i];
            if (min > j) {
                min = j;
                shortest = i;
            }
            if (max < j) {
                max = j;
                longest = i;
            }
        }

        System.out.println("Cамое короткое первое число: " + massiv[shortest] + "." + " Его длина: " + min + ";");
        System.out.println("Cамое длинное первое число: " + massiv[longest] + "." + " Его длина: " + max + ";");

    }
}
