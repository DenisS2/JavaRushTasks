package com.javarush.task.task34.task3411;

/* 
Ханойские башни
*/

public class Solution {
    public static void main(String[] args) {
        int count = 3;
        moveRing('A', 'B', 'C', count);
    }

    public static void moveRing(char a, char b, char c, int count) {
        //напишите тут ваш код

        if ( count == 1 )
        {
            System.out.println( "from "+a+" to "+b);
            return;
        }

        moveRing(  a, c, b , count-1);

        // перместить последнее кольцо с исходного стержня на нужный стержень
        System.out.println( "from "+a+" to "+b );

        // переместить ( rings - 1 ) колец с временного стержня на нужный стержень
        moveRing(  c, b, a , count-1);}
}