package com.javarush.task.task21.task2113;

import java.util.*;


public class Hippodrome {

    private List<Horse> horses = new ArrayList<Horse>();

    public Hippodrome(List list){
        horses=list;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public static Hippodrome game;


    public static void main(String[] args) throws InterruptedException {
        game=new Hippodrome(new ArrayList());
        Horse horse1 = new Horse("Alisa", 3, 0);
        Horse horse2 = new Horse("Bystriy", 3, 0);
        Horse horse3 = new Horse("Perviy", 3, 0);
        game.getHorses().add(horse1);
        game.getHorses().add(horse2);
        game.getHorses().add(horse3);
        game.run();
        game.printWinner();
    }

    public void run() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }

    }

    public void move(){
        for (Horse h:horses) {
            h.move();
        }

    }

    public void print(){
        for (Horse h:horses) {
            h.print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }

    }

    public Horse getWinner(){
        Horse horseWinner=null;
        double d=0;
        for (Horse h:horses) {
            if (h.distance>d) {
                d=h.distance;
                horseWinner=h;
            }
        }
        return horseWinner;
    }

    public void printWinner(){
        System.out.println("Winner is "+getWinner().getName()+"!");
    }
}
