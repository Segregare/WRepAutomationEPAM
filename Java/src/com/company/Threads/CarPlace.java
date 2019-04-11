package com.company.Threads;

public class CarPlace {
    private int PlaceId;
    public CarPlace(int id) {
        super();
        this.PlaceId = id;
    }
    public int getPlaceId() {
        return PlaceId;
    }
    public void setPlaceId(int id) {
        this.PlaceId = id;
    }
    public void using() {
        try {
            // использование канала
            Thread.sleep(new java.util.Random().nextInt(500));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}