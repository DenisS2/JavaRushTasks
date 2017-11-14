package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        testStrategy(new HashMapStorageStrategy(),10000);
        testStrategy(new OurHashMapStorageStrategy(),10000);
        testStrategy(new HashBiMapStorageStrategy(),10000);
        testStrategy(new DualHashBidiMapStorageStrategy(),10000);
    }


    public static Set<Long> getIds(Shortener shortener, Set<String> strings){
        Set<Long>  ids = new HashSet<>();
        for (String s:strings) {
            ids.add(shortener.getId(s));
        }
        return ids;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys){
        Set<String>  strings = new HashSet<>();
        for (Long l:keys) {
            strings.add(shortener.getString(l));
        }
        return strings;
    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber) {
        Helper.printMessage(strategy.getClass().getSimpleName());

        Set<String> strings = new HashSet<>();

        for (int i = 0; i < elementsNumber; i++) {
            strings.add(Helper.generateRandomString());
        }

        //System.out.println(strings);

        Shortener shortener = new Shortener(strategy);

        Date dateGetIdStart = new Date();
        Set<Long> ids = getIds(shortener, strings);
        Date dateGetIdStop = new Date();
        long time = dateGetIdStop.getTime() - dateGetIdStart.getTime();//timeStop-timeStart;
        Helper.printMessage(Long.toString(time));

        Date dateGetStringsStart = new Date();
        Set<String> newStrings = getStrings(shortener, ids);
        Date dateGetStringsStop = new Date();
        time = dateGetStringsStop.getTime() - dateGetStringsStart.getTime();
        Helper.printMessage(Long.toString(time));

        if (strings.equals(newStrings)) Helper.printMessage("Тест пройден.");
        else Helper.printMessage("Тест не пройден.");
        System.out.println();
    }

}
