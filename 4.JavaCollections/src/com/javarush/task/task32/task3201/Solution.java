package com.javarush.task.task32.task3201;


import java.io.IOException;
import java.io.RandomAccessFile;

/*
Запись в существующий файл
*/
public class Solution {
    public static void main(String... args) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(args[0], "rw");
        if (raf.length()<Long.parseLong(args[1])) raf.seek(raf.length());
        else raf.seek( Long.parseLong(args[1]));
        //raf.writeBytes(args[2].toString());
        raf.write(args[2].getBytes());
        raf.close();
    }
}
