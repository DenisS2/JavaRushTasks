package com.javarush.task.task36.task3610;

import java.io.Serializable;
import java.util.*;

public class MyMultiMap<K, V> extends HashMap<K, V> implements Cloneable, Serializable {
    static final long serialVersionUID = 123456789L;
    private HashMap<K, List<V>> map;
    private int repeatCount;

    public MyMultiMap(int repeatCount) {
        this.repeatCount = repeatCount;
        map = new HashMap<>();
    }

    @Override
    public int size() {
        return values().size();
        //напишите тут ваш код
    }

    @Override
    public V put(K key, V value) {
        /*if (map.containsKey(key)){
            if (map.get(key).size()<repeatCount) {
                map.get(key).add(value);
            }
            else {
                map.get(key).remove(0);
                map.get(key).add(value);
            }
        }
        else {
            map.put(key, new ArrayList<V>());
            map.get(key).add(value);
        }
        if (map.get(key).size()!=0) return map.get(key).get(map.get(key).size()-2);
        else return null;*/
        //напишите тут ваш код
        List<V> values = map.get(key);
        V oldValue = null;

        if (values == null) {
            values = new ArrayList<>();

        } else {
            oldValue = values.get(values.size()-1);
            if (values.size() == repeatCount)
                values.remove(0);
        }

        values.add(value);
        map.put(key, values);
        return oldValue;
    }

    @Override
    public V remove(Object key) {
        /*V v=null;
        if (!map.containsKey(key)) return null;
        if (map.get(key).size()>0) {
            v=map.get(key).get(0);
                map.get(key).remove(0);
    }
        else map.remove(key);
        return v;*/
        //напишите тут ваш код

            //напишите тут ваш код
            List<V> values = map.get(key);
            if (values == null)
                return null;

            V storeValue = values.get(0);
            values.remove(0);

            if (values.size() == 0)
                map.remove(key);

            return storeValue;


    }

    @Override
    public Set<K> keySet() {
        return map.keySet();
        //напишите тут ваш код
    }

    @Override
    public Collection<V> values() {
        ArrayList<V> list = new ArrayList<>();
        for (Map.Entry<K, List<V>> entry: map.entrySet()) {
            //String key = (String) entry.getKey();
            List<V> value =  entry.getValue();
            list.addAll(value);
        }
        return list;
        //напишите тут ваш код
    }

    @Override
    public boolean containsKey(Object key) {
        if (map.containsKey(key)) return true;
        else return false;
        //напишите тут ваш код
    }

    @Override
    public boolean containsValue(Object value) {
        for (Map.Entry<K, List<V>> entry : map.entrySet()) {
            for (V v : entry.getValue()) {
                if (v.equals(value)) return true;
            }
        }
        return false;
        //напишите тут ваш код
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (Map.Entry<K, List<V>> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            for (V v : entry.getValue()) {
                sb.append(v);
                sb.append(", ");
            }
        }
        String substring = sb.substring(0, sb.length() - 2);
        return substring + "}";
    }
}