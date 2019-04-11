package com.company.TaskAClasses;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


public class TaskA{

    static Comparator<Purchaser> name = new Comparator<Purchaser>() {

        public int compare(Purchaser o1, Purchaser o2) {
            return o1.name.compareTo(o2.name);
        }
    };

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        PurchaserArray purchasers;
        purchasers = new PurchaserArray();
        purchasers.add(new Purchaser("Сковырко","Дмитрий","Артемович","Минск",1111,"111111111"));
        purchasers.add(new Purchaser("Тарас","Денис","Александрович","Минск",2222,"222222222"));
        purchasers.add(new Purchaser("Поминов","Андрей","Викторович","Минск",3333,"333333333"));
        purchasers.add(new Purchaser("Сивкова","Кристина","Геннадьевна","Минск",4444,"444444444"));
        purchasers.add(new Purchaser("Серебряков","Богдан","Евгеньевич","Минск",5555,"555555555"));

        PurchaserArray purchasersSelected = new PurchaserArray();

//        Задать критерий выбора данных
//        и вывести эти данные на консоль
        purchasersSelected = purchasers.selectByName("Денис");
        purchasersSelected.PurchasersOut();
        System.out.println();
        System.out.print("Список покупателей:\n");



        //a) список покупателей в алфавитном порядке;
        Collections.sort(purchasers,name);
        purchasers.PurchasersOut();
        System.out.println();

        //b) список покупателей, у которых номер кредитной карточки находится
        //   в заданном интервале.
        System.out.print("Наименьшее число интервала: ");
        int firstPosition = scan.nextInt();
        System.out.print("Наибольшее число интервала: ");
        int secondPosition = scan.nextInt();
        System.out.print("Список покупателей, у которых номера карт входят в заданный интервал:\n");
        for (int i = 0; i <= purchasers.size()-1;i++){
            Purchaser purchaser = (Purchaser) purchasers.get(i);
            if(purchaser.getCard() >= firstPosition && purchaser.getCard() <= secondPosition)
                purchaser.toString(purchaser);
        }
    }
}

class Purchaser extends Object {


    private String surname;
    public String name;
    private String patronymic;
    private String address;
    private int numberOfCard;
    private String bankAccount;


    public Purchaser(String surname, String name, String patronymic, String address, int numberOfCard, String bankAccount){

        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.address = address;
        this.numberOfCard = numberOfCard;
        this.bankAccount = bankAccount;

    }

    public void setSurname(String surname){
        this.surname = surname;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setPatronymic(String patronymic){
        this.patronymic = patronymic;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public void setNumberOfCard(int numberOfCard){
        this.numberOfCard = numberOfCard;
    }

    public void setBankAccount(String bankAccount){
        this.bankAccount = bankAccount;
    }



    public String getSurname(){
        return this.surname;
    }
    public String getName(){
        return this.name;
    }
    public String getPatronymic(){
        return this.patronymic;
    }
    public int getCard(){
        return this.numberOfCard;
    }
    public String getBankAccount(){
        return this.bankAccount;
    }

    public String getAddress() {
        return this.address;
    }


    public void toString(Purchaser purchaser){
        System.out.println("Purchaser: " + this.surname + " " + this.name + " " + this.patronymic + "; Address: " + this.address + "; Number of card:" + this.numberOfCard + "; Bank Account:" + this.bankAccount);
    }
}

class PurchaserArray extends ArrayList{

    public PurchaserArray selectByName(String name){

        PurchaserArray result = new PurchaserArray();

        for(int i=0;i <= this.size()-1;i++) {
            Purchaser purchaser = (Purchaser) this.get(i);
            if (purchaser.getName() == name) {
                result.add(purchaser);
            }
        }
        return result;
    }

    public void PurchasersOut(){
        for(int i=0;i <= this.size()-1;i++){
            Purchaser purchaser = (Purchaser) this.get(i);
            purchaser.toString(purchaser);
        }
    }
}
