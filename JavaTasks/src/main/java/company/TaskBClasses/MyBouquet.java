package company.TaskBClasses;

import java.util.Scanner;

public class MyBouquet {
    public static void main(String[] args){

        //Создать несколько объектов-цветов.
        System.out.println("Here are some flowers:");

        Knapweed chr = new Knapweed(1, 15, 1);
        System.out.println(chr);

        Rose rose = new Rose();
        System.out.println(rose);

        Rose rose2 = new Rose();
        System.out.println(rose2);

        Rose rose3 = new Rose(1, 25, 5);
        System.out.println(rose3);

        System.out.println("Цветочный магазин: ");
        System.out.println("1: Собрать букет");
        System.out.println("2: Провести сортировку цветов в букете на основе уровня свежести");
        System.out.println("3: Найти цветок в букете, соответствующий заданному диапазону длин стеблей");
        System.out.println("4: Выйти из магазина");


        Scanner keyboard = new Scanner(System.in);

        Bouquet myBouquet = new Bouquet(3, 0, 2, true, false);

        while (true) {
            System.out.println();
            System.out.println("Ваш выбор: ");
            int firstItem = keyboard.nextInt();
            switch (firstItem) {
                case 1:
                    //Собрать букет (используя аксессуары) с  определением его стоимости.
                        System.out.println("Bouquet with accessories and it's price:");
                        System.out.println(myBouquet);
                        System.out.println("This bouquet price is $" + myBouquet.getPrice() + ".");
                    break;
                case 2:
                    //Провести сортировку цветов в букете на основе уровня свежести.
                        System.out.println("Sorted bouquet by freshness of flowers:");
                        myBouquet.sortFlowers();
                        System.out.println(myBouquet);
                        System.out.println("This bouquet price is $" + myBouquet.getPrice() + ".");
                    break;
                case 3:
                    //Найти цветок в  букете, соответствующий заданному диапазону длин стеблей.
                        System.out.println("Here we find flowers in our bouquet with given stem length:");
                        System.out.println(myBouquet.findStemLength(30, 60));
                    break;
                case 4:
                    System.out.println("Спасибо, что выбрали наш магазин!!! ");
                    return;
            }
        }
    }
}