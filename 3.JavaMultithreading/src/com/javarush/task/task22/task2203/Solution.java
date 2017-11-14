package com.javarush.task.task22.task2203;

/* 
Между табуляциями
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        if (string == null)
            throw new TooShortStringException();
        int count=0;
        int first=string.indexOf("\t");
        if (first==-1) throw new TooShortStringException();
        count++;
        int end =string.indexOf("\t",first+1);
        if (end==-1) throw new TooShortStringException();
        count++;
        if (count<2) throw new TooShortStringException();
        return string.substring(first+1, end);
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис обучения Java\t."));
    }
}
