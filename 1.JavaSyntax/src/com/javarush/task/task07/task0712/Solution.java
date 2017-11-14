package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/*
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner sc = new Scanner(System.in);
        ArrayList<String> list =new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add(sc.nextLine());
        }
        int[] dl= new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            dl[i]=list.get(i).length();
        }
        int max=0;
        int min=dl[0];
        int posmax=0;
        int posmin=0;
        for (int i = 0; i < dl.length; i++) {
            if (max<dl[i]){ max=dl[i]; posmax=i;}
            if (min>dl[i]){ min=dl[i];posmin=i;}
        }
        if (posmin<posmax) System.out.println(list.get(posmin));
        else System.out.println(list.get(posmax));
    }
}
