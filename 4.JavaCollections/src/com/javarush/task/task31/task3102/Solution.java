package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.*;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        List<String> list = new ArrayList<>();
        Stack<File> stack = new Stack<>();
        File file = new File(root);
        File[] f=file.listFiles();
        for (int i = 0; i < f.length ; i++) {
            stack.push(f[i]);
        }
        while (!stack.empty()){
            file=stack.pop();
            if (file.isDirectory()){
                File[] tmp= file.listFiles();
                for (int i = 0; i < tmp.length; i++) {
                    stack.push(tmp[i]);
                }
            }
            else if (file.isFile()){
                list.add(file.getAbsolutePath());
            }
        }

        return list;

    }

    public static void main(String[] args) throws IOException {
        List<String> list=getFileTree(args[0]);
        System.out.println(list);
    }
}
