package com.javarush.task.task22.task2210;

import java.util.ArrayList;
import java.util.StringTokenizer;

/*
StringTokenizer
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getTokens("level22.lesson13.task01", "."));
    }
    public static String [] getTokens(String query, String delimiter) {
        StringTokenizer tokenizer = new StringTokenizer(query,delimiter);
        ArrayList<String> list = new ArrayList();
        while (tokenizer.hasMoreTokens())
        {
            String token = tokenizer.nextToken();
            list.add(token);
        }
        String[]s = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            s[i]=list.get(i);
            //System.out.println(s[i]);
        }

        return s;
    }
}
