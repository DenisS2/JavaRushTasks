package com.javarush.task.task22.task2202;

/* 
Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис  обучения Java"));
    }

    /*public static String getPartOfString(String string) {
        if (string == null)
            throw new TooShortStringException();
            int first = string.indexOf(' ');
        if (first==-1) throw new TooShortStringException();
            int end = first;
            for (int i = 0; i < 4; i++) {
                end = string.indexOf( ' ', end + 1);
                if (end==-1) throw new TooShortStringException();
                if (string.charAt(end-1)==' ') throw new TooShortStringException();
            }
        return string.substring(first + 1, end);
    }*/

    public static String getPartOfString(String string) {
        if (string == null)
            throw new TooShortStringException();
        int count = 0;
        for (int i = 0; i < string.length(); i++) {
            if(Character.toString(string.charAt(i)).equals(" ")){
                count++;
            }
        }
        if (count < 4) {
            throw new TooShortStringException();
        } else {
            String s[] = string.split(" ");
            String s1 = s[1] + " " + s[2] + " " + s[3] + " " +  s[4];
            return s1; }
    }

    public static class TooShortStringException extends RuntimeException {
        public TooShortStringException() {
            super();
        }
    }
}

