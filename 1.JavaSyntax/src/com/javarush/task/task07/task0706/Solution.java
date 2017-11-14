package com.javarush.task.task07.task0706;


import java.util.Scanner;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int ch=0;
        int nc=0;
        Scanner sc = new Scanner(System.in);
        int[] mas = new  int[15];
        for (int i = 0; i < mas.length ; i++) {
            mas[i] = sc.nextInt();
            if (i%2==0) ch=ch+mas[i];
            else nc=nc+mas[i];
        }
        sc.close();

        if (ch<nc) System.out.println("В домах с нечетными номерами проживает больше жителей.");
        else System.out.println("В домах с четными номерами проживает больше жителей.");
    }
}
