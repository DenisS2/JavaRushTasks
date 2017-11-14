package com.javarush.task.task32.task3213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

/* 
Шифр Цезаря
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringReader reader = new StringReader("Khoor Dpljr");
        System.out.println(decode(reader, -3));  //Hello Amigo

    }

    public static String decode(StringReader reader, int key) throws IOException {
        if (reader!=null){
        /*BufferedReader br = new BufferedReader(reader);
        String line="";
        int b=0;
        char[] chars= new char[reader.toString().length()];
           br.read(chars);
        for (char c:chars) {
            if ((byte)c>64&&(byte)c<91||(byte)c>96&&(byte)c<123||(byte)c>47&&(byte)c<58)
            {
            b =(byte)c+key;}
            else b=(byte)c;
            line=line+(char)b;
        }
        return line.trim();*/
            String result = "";
            int c;
            while ((c = reader.read()) != -1) {
                result += (char) (c + key);
            }
            return result;
        }

    return "null";
    }


}
