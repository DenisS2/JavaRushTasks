package com.javarush.task.task06.task0612;

/* 
Калькулятор
*/

public class Calculator {
    public static int plus(int a, int b) {
        //напишите тут ваш код
        int c=a+b;
        return c;
    }

    public static int minus(int a, int b) {
        //напишите тут ваш код
        int c=a-b;
        return c;
    }

    public static int multiply(int a, int b) {
        //напишите тут ваш код
        int c=a*b;
        return c;
    }

    public static double division(int a, int b) {
        //напишите тут ваш код
        double c=(double) a/b;
        return c;
    }

    public static double percent(int a, int b) {
        //напишите тут ваш код
        double c=(double) a/100;
        double percent=c*b;
        return percent;
    }

    public static void main(String[] args) {
        //int a=80;
        //int b=40;
        //System.out.println(percent(a,b));
    }
}