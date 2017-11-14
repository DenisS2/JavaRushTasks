package com.javarush.task.task39.task3913;

import java.io.File;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) throws ParseException {
        LogParser logParser = new LogParser(Paths.get("d:/logs/"));
        //System.out.println(logParser.getNumberOfUniqueIPs(null, new Date()));


        File file = new File("d:/logs/");
       // File[] files=file.listFiles();
        //for (File f:files) {
        //    if (f.getName().substring(f.getName().length()-3,f.getName().length()).toLowerCase().equals("log"))
         //   System.out.println(f);
        //}
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        Date after=dateFormat.parse("03.01.2014 03:45:23");
        Date before=dateFormat.parse("13.09.2013 5:04:50");
        Set<String> set=logParser.getDoneTaskUsers(null,null,48);
        System.out.println(set.toString());

    }
}