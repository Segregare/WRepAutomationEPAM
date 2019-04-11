package com.company.TaskBClasses;

public class Accessory {

    private int price;

    Accessory(int price) {
        this.price = price;
    }

    Accessory(){}

    @Override
    public String toString(){
        return "Accessory price: $" + price + ".";
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}