package com.javarush.task.task06.task0606;

import java.io.*;
import java.util.Scanner;

/* 
Чётные и нечётные циферки
*/

public class Solution {

    public static int even=0;
    public static int odd=0;

    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        Scanner sc = new Scanner(System.in);
        String s=sc.nextLine();
        sc.close();
        for (int i = 0; i < s.length(); i++) {
            char ch=s.charAt(i);
            int digit= (int) ch-48;
            if (digit%2==0)even++;
            else odd++;
        }
        System.out.println("Even: "+ even+ " Odd: "+ odd);
    }
}
