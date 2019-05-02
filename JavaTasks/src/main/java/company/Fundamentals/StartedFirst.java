package company.Fundamentals;

import java.util.Scanner;

public class StartedFirst {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Введите имя: ");
        String name = scn.nextLine();
        System.out.println("Добро пожаловать," + name);
    }
}
