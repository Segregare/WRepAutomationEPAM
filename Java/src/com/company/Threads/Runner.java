package com.company.Threads;

import java.util.LinkedList;


public class Runner {
    public static void main(String[] args) {
        LinkedList<CarPlace> list = new LinkedList<CarPlace>() {
            {
                this.add(new CarPlace(1));
                this.add(new CarPlace(2));
                this.add(new CarPlace(3));
                this.add(new CarPlace(4));
                this.add(new CarPlace(5));
            }
        };
        CarPlacePool<CarPlace> pool = new CarPlacePool<>(list);
        for (int i = 0; i < 20; i++) {
            new Car(pool).start();
        }
    }
}
