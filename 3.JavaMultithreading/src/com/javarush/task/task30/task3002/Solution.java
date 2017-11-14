package com.javarush.task.task30.task3002;

/* 
Осваиваем методы класса Integer
*/
public class Solution {

    public static void main(String[] args) {
        System.out.println(convertToDecimalSystem("0x16")); //22
        System.out.println(convertToDecimalSystem("012"));  //10
        System.out.println(convertToDecimalSystem("0b10")); //2
        System.out.println(convertToDecimalSystem("62"));   //62
    }

    public static String convertToDecimalSystem(String s) {
        //напишите тут ваш код
        char[] c = s.toCharArray();
        String result = "";
        int i = 0;
        if (c[0] != '0') {
            i = Integer.parseInt(s, 10);
        }
        else if (c[1] == 'x'){
            s=s.substring(2);
            i = Integer.parseInt(s, 16);
        }
        else if (c[1] == 'b'){
            s=s.substring(2);
            i = Integer.parseInt(s, 2);
        }
        else i = Integer.parseInt(s, 8);

        result = result + i;
        return result;
    }
}
