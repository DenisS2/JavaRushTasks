package com.javarush.task.task07.task0718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/* 
Проверка на упорядоченность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        Scanner sc = new Scanner(System.in);
        ArrayList<String> list =new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add(sc.nextLine());
        }
        int l=0;
        int[] dl= new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            dl[i]=list.get(i).length();
            if (dl[i]<l){
                System.out.println(i);
                break;
            }
            else l=dl[i];
        }
    }
}

