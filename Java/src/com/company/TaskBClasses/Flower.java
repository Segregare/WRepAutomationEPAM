package com.company.TaskBClasses;

public class Flower {

    private int freshness;
    private int stemLength;
    private int price;

    Flower(int freshness, int stemLength, int price) {
        this.freshness = freshness;
        this.stemLength = stemLength;
        this.price = price;
    }

    Flower(){}

    @Override
    public String toString(){
        String day = " day";
        if(freshness > 1){
            day = " days";
        }
        return "This flower freshness is " + freshness + day + ", stem length is " + stemLength + " cm., price: $" + price + ".";
    }

    int getFreshness(){
        return freshness;
    }

    int getStemLength() {
        return stemLength;
    }

    public int getPrice() {
        return price;
    }

    void setFreshness(int freshness) {
        this.freshness = freshness;
    }

    void setStemLength(int stemLength) {
        this.stemLength = stemLength;
    }

    void setPrice(int price) {
        this.price = price;
    }
}