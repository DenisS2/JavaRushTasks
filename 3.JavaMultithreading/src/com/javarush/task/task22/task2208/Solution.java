package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* 
Формируем WHERE
"name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'"
*/
public class Solution {
    public static void main(String[] args) {
        LinkedHashMap<String, String> map = new LinkedHashMap();
        map.put("name", "Ivanov");
        map.put("country", "Ukraine");
        map.put("city", "Kiev");
        map.put("age", null);

        System.out.println(getQuery(map));

    }
    public static String getQuery(Map<String, String> params) {

        StringBuilder builder = new StringBuilder();
        if (params == null || params.isEmpty()) return builder.toString();

        for(Map.Entry<String, String> entry : params.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (key!=null&&value!=null)
            builder.append(key).append(" = '").append(value).append("' and ");
        }
        if (builder.length() > 5) builder.delete(builder.length()-5,builder.length());
        return builder.toString();
    }
}
