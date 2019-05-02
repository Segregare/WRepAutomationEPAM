package company.Collections;


import java.util.*;

public class MainTaskFirst {
    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();
        int size = 10;
        for(int i = 0; i < size; i++){
            list.add(i + 1);
        }
        System.out.println("ArrayList\n");
        System.out.println("В кругу стоят " + size + " человек: " + list);

        int personRemove = 0;
        for (int i = 0; i < size; i++){
            if(list.size() != 1){
                personRemove = (personRemove + 1) % list.size();
                list.remove(personRemove);
            }
        }
        System.out.println("\nВ кругу остался: " + list);

        LinkedList<Integer> link = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            link.add(i + 1);
        }
        System.out.println("\nLinkedList");
        System.out.println("\nВ кругу стоят " + size + " человек: " + link);

        personRemove = 0;

        for (int i = 0; i < size; i++) {
            if (link.size() != 1) {
                personRemove = (personRemove + 1) % link.size();
                link.remove(personRemove);

            }
        }
        System.out.println();
        System.out.println("В кругу остался: " + list);
    }
}
