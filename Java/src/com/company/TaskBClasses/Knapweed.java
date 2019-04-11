package com.company.TaskBClasses;

class Knapweed extends Flower{

    Knapweed(int freshness, int stemLength, int price) {
        super(freshness, stemLength, price);
    }

    Knapweed() {
        super(3, (int)(40 + (Math.random() * 20)), 2);
    }

    @Override
    public String toString(){
        String day = " day";
        if(getFreshness() > 1){
            day = " days";
        }
        return "This Knapweed freshness is " + getFreshness() + day + ", stem length is " + getStemLength() + " cm., " +
                "price:" + " $" + getPrice() + ". \n";
    }

}