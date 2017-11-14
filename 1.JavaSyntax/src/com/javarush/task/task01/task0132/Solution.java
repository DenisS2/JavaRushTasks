package com.javarush.task.task01.task0132;

/* 
Сумма цифр трехзначного числа
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(sumDigitsInNumber(546));
    }

    public static int sumDigitsInNumber(int number) {
        //напишите тут ваш код
        int result=0;
        String s=""+number;
        for (int i = 0; i <s.length() ; i++) {
            result=result+s.charAt(i);
        }
        return result-48*s.length();
    }
}