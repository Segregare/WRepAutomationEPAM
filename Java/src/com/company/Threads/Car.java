package com.company.Threads;


public class Car extends Thread {
    private boolean reading = false;
    private CarPlacePool<CarPlace> pool;
    public Car(CarPlacePool<CarPlace> pool) {
        this.pool = pool;
    }
    public void run() {

        CarPlace channel = null;
        try {
            channel = pool.getResource(100);
            reading = true;
            System.out.println("Автомобиль №" + this.getId()
                    + " занял машиноместо #" + channel.getPlaceId());
            channel.using();
        } catch (ResourсeException e) {
            System.out.println("Автомобиль №" + this.getId() + " уехал на другую парковку"
                    + e.getMessage());
        } finally {
            if (channel != null) {
                reading = false;
                System.out.println("Автомобиль №" + this.getId() + " : "
                         + " освободил машиноместо #" + channel.getPlaceId());
                pool.returnResource(channel);
            }
        }
    }
    public boolean isReading() {
        return reading;
    }
}