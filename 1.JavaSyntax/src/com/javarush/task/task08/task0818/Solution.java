package com.javarush.task.task08.task0818;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        //напишите тут ваш код
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Ivanov1", 100);
        map.put("Ivanov2", 200);
        map.put("Ivanov3", 300);
        map.put("Ivanov4", 400);
        map.put("Ivanov5", 500);
        map.put("Ivanov6", 600);
        map.put("Ivanov7", 700);
        map.put("Ivanov8", 800);
        map.put("Ivanov9", 900);
        map.put("Ivanov0", 1000);

        return map;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        //напишите тут ваш код
        ArrayList<String> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key=entry.getKey();
            int value =entry.getValue();
            if (value<500) list.add(key);
        }
        for (String s:list) {
            map.remove(s);
        }
    }

    public static void main(String[] args) {
       // HashMap map=createMap();
       // removeItemFromMap(map);
       // System.out.println(map);
    }
}