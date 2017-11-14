package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        int i=0, count=0;
        double result=0;
        while (i!=-1){
            i=scanner.nextInt();
            if (i!=-1){
                result=result+i;
                count++;
            }
        }
        result=result/count;
        System.out.println(result);
    }
}

