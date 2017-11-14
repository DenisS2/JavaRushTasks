package com.javarush.task.task29.task2909.car;

import java.util.Date;

public abstract class Car {
    static public final int TRUCK = 0;
    static public final int SEDAN = 1;
    static public final int CABRIOLET = 2;
    static public final int MAX_TRUCK_SPEED=80;
    static public final int MAX_SEDAN_SPEED=120;
    static public final int MAX_CABRIOLET_SPEED=90;


    double fuel;

    public double summerFuelConsumption;
    public double winterFuelConsumption;
    public double winterWarmingUp;

    private int type;

    private boolean driverAvailable;
    private int numberOfPassengers;

    protected Car(int type, int numberOfPassengers) {
        this.type = type;
        this.numberOfPassengers = numberOfPassengers;
    }

    //public static Car create(int type, int numberOfPassengers){
    //    return new Car(type,numberOfPassengers);
    //}
    public static Car create(int type, int numberOfPassengers) {

        switch (type) {
            case CABRIOLET:
                return new Cabriolet(numberOfPassengers);
            case SEDAN:
                return new Sedan(numberOfPassengers);
            case TRUCK:
                return new Truck(numberOfPassengers);
            default:
                return null;//new Car(type, numberOfPassengers);
        }
    }

    private boolean canPassengersBeTransferred(){
        if (isDriverAvailable()&& fuel>0) return true;
        else return false;
    }

    public void fill(double numberOfLiters) throws Exception {
        if (numberOfLiters < 0)
             throw  new Exception();
        fuel += numberOfLiters;
    }

    public boolean isSummer(Date date , Date summerStart, Date summerEnd){
        if (date.after(summerStart) && date.before(summerEnd)) return true;
        else return false;
    }

    public double getWinterConsumption(int length){
        return length * winterFuelConsumption + winterWarmingUp;
    }

    public double getSummerConsumption(int length) {
        return length * summerFuelConsumption;
    }

    public double getTripConsumption(Date date, int length, Date SummerStart, Date SummerEnd) {
        double consumption;
        //if (date.before(SummerStart) || date.after(SummerEnd)) {
        //    consumption = length * winterFuelConsumption + winterWarmingUp;
        //} else {
        //    consumption = length * summerFuelConsumption;
        //}
        //return consumption;
        if (isSummer(date,SummerStart,SummerEnd)) consumption=getSummerConsumption(length);
        else consumption=getWinterConsumption(length);
        return consumption;
    }

    public int getNumberOfPassengersCanBeTransferred() {
        if (!canPassengersBeTransferred())
            return 0;

        return numberOfPassengers;
    }

    public boolean isDriverAvailable() {
        return driverAvailable;
    }

    public void setDriverAvailable(boolean driverAvailable) {
        this.driverAvailable = driverAvailable;
    }

    public void startMoving() {
        if (numberOfPassengers > 0) fastenPassengersBelts();
            fastenDriverBelt();
    }

    public void fastenPassengersBelts() {
    }

    public void fastenDriverBelt() {
    }

    public abstract int getMaxSpeed();
}