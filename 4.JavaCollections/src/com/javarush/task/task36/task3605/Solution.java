package com.javarush.task.task36.task3605;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;

/* 
Использование TreeSet
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader(new File(args[0]));
        TreeSet treeSet = new TreeSet();
        String s="";

        while (fileReader.ready())
            s=s+(char)fileReader.read();

            //treeSet.add((char)fileReader.read());
        fileReader.close();
        s=s.toLowerCase();
        byte[] b=s.getBytes();
        for (byte bb:b) {
            if (bb>96&&bb<123){
                treeSet.add((char) bb);
            }
        }
        for (int i = 0; i <5 ; i++) {
            if (!treeSet.isEmpty()){
            System.out.print(treeSet.pollFirst());
            //treeSet.remove(treeSet.first());
            }
        }
    }
}
