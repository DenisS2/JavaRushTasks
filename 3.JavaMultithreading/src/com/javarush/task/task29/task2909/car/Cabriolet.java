package com.javarush.task.task29.task2909.car;


/**
 * Created by User on 12.06.2017.
 */
public class Cabriolet extends Car {
    public Cabriolet(int type, int numberOfPassengers) {
        super(type, numberOfPassengers);
    }

    public Cabriolet(int numberOfPassengers){
        super(2,numberOfPassengers);
    }

    public int getMaxSpeed() {
        return MAX_CABRIOLET_SPEED;
    }

}
