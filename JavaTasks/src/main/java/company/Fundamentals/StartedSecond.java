package company.Fundamentals;

import java.util.Scanner;

public class StartedSecond {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Введите первое число: ");
        int first = scn.nextInt();
        System.out.println("Введите второе число: ");
        int second = scn.nextInt();
        System.out.println("Введите третье число: ");
        int third = scn.nextInt();
        int sum = first+second+third;
        int composition = first*second*third;
        System.out.println("Cумма равна:" + sum + "\nПроизведение равно:" + composition);
    }
}
