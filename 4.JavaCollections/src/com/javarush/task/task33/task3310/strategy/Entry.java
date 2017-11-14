package com.javarush.task.task33.task3310.strategy;

import java.io.Serializable;

public class Entry implements Serializable {

     Long key;
     String value;
     Entry next;
     int hash;

    public Entry(int hash, Long key, String value, Entry next) {
        this.key = key;
        this.value = value;
        this.next = next;
        this.hash = hash;
    }

    public Long getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Entry)) return false;

        long key=getKey();
        long equalsKey=((Entry) o).key;

        String value=getValue();
        String equalsValue=((Entry) o).value;

        if (key==equalsKey&&value==equalsValue) return true;
        else return false;
    }

    @Override
    public int hashCode() {
        int result = getKey() != null ? getKey().hashCode() : 0;
        result = 31 * result + (getValue() != null ? getValue().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {

         return new String(key + "=" + value);
    }
}
