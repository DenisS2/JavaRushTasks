package com.javarush.task.task32.task3210;


import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(args[0], "rw");
        byte[] b = new byte[args[2].length()];
        raf.seek(Long.parseLong(args[1]));
        raf.read(b, 0, b.length);
        String s=convertByteToString(b);
        raf.seek(raf.length());
        if(s.equals(args[2])) raf.write("true".getBytes());
        else raf.write("false".getBytes());
        //if (raf.length()<Long.parseLong(args[1])) raf.seek(raf.length());
        //else raf.seek( Long.parseLong(args[1]));
        //raf.writeBytes(args[2].toString());
        //raf.write(args[2].getBytes());
        raf.close();

    }

    private static String convertByteToString(byte[] b) {
        return new String(b);
    }
}
