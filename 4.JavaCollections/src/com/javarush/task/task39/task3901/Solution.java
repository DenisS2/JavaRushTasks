package com.javarush.task.task39.task3901;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* 
Уникальные подстроки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please input your string: ");
        String s = bufferedReader.readLine();

        System.out.println("The longest unique substring length is: \n" + lengthOfLongestUniqueSubstring(s));
    }


    public static int lengthOfLongestUniqueSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;

        ArrayList<Integer> lenghtList = new ArrayList<>();


        for (int ii = 0; ii < s.length(); ii++) {
            String sss = s.substring(ii, s.length());

            StringBuffer noRepeatLattersString = new StringBuffer();
            noRepeatLattersString.append(sss.charAt(0));
            exit:
            for (int i = 1; i < sss.length(); i++) {
                for (int j = 0; j < noRepeatLattersString.length(); j++)
                    if (noRepeatLattersString.charAt(j) == sss.charAt(i))
                        break exit;

                noRepeatLattersString.append(sss.charAt(i));
            }
            lenghtList.add(noRepeatLattersString.toString().length());
        }

        return Collections.max(lenghtList);
    }
    /*public static int lengthOfLongestUniqueSubstring(String s) {


        try {
        if (s.equals("")||s.equals(null)) return 0;
        }
        catch (NullPointerException e){
            return 0;
        }

        Set<Character>  charList= new HashSet<>();
        Set<Set<Character>> listString = new HashSet<>();
        char[] chars= s.toCharArray();
        for (int i = 0; i < chars.length-1; i++) {
            charList.add(chars[i]);
            for (int j = i+1; j < chars.length; j++) {
                if (!charList.contains(chars[j])){
                    charList.add(chars[j]);
                    if (j==chars.length-1){
                        listString.add(charList);
                        charList=new HashSet<>();
                        break;
                    }
                }
                else {
                    listString.add(charList);
                    charList=new HashSet<>();
                    break;
                }
            }
        }
        int size=0;

        for (Set<Character> a:listString) {
            if (a.size()>size) size=a.size();
        }
        return size;
    }*/


}
