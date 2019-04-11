package com.company.TaskBClasses;

class Lilac extends Flower {

    Lilac(int freshness, int stemLength, int price) {
        super(freshness, stemLength, price);
    }

    Lilac() {
        super(1, (int)(50 + (Math.random() * 20)), 1);
    }

    @Override
    public String toString(){
        String day = " day";
        if(getFreshness() > 1){
            day = " days";
        }
        return "This Lilac freshness is " + getFreshness() + day + ", stem length is " + getStemLength() + " cm., " +
                "price:" + " $" + getPrice() + ". \n";
    }

}