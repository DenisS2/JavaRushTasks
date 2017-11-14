package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.util.Random;

/* 
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Random random = new Random();
        boolean m = false;
        boolean b = false;
        boolean d = false;
        while (true) {
            int c = random.nextInt(127);
            if (c > 64 && c < 91) {
                b = true;
                byteArrayOutputStream.write(c);
            } else if (c > 96 && c < 123) {
                m = true;
                byteArrayOutputStream.write(c);
            } else if (c > 47 && c < 58) {
                d = true;
                byteArrayOutputStream.write(c);
            }
            if (byteArrayOutputStream.size() == 8) break;
        }
        if (b==false || m==false || d==false)
            byteArrayOutputStream=getPassword();

        return byteArrayOutputStream;
    }
}