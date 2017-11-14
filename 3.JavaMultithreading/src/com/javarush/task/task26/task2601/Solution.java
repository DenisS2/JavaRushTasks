package com.javarush.task.task26.task2601;

import java.util.ArrayList;
import java.util.Collections;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {
    //    Integer[] array = {13, 8, 15, 5, 17, 22};//new Integer[5];
    //    array=sort(array);
    //    for (Integer n:array) System.out.println(n);

    }

    public static Integer[] sort(Integer[] array) {
        //implement logic here
        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list, array);
        Collections.sort(list);
        int median;
        int index;
        ArrayList<Integer> result = new ArrayList<>();
        if (list.size()%2==0){
            median=(list.get(list.size() / 2) + list.get(list.size() / 2 - 1)) / 2;
            //result.add(median);
        }
        else {
            median=list.get((list.size())/2);
            result.add(median);
            index=list.indexOf(median);
            list.remove(index);
        }
        int i=1;
        while (!list.isEmpty()){

            if (list.contains(median-i)){
                result.add(median-i);
                index=list.indexOf(median-i);
                list.remove(index);
            }
            if (list.contains(median+i)){
                result.add(median+i);
                index=list.indexOf(median+i);
                list.remove(index);
            }
            i++;
        }
        array = result.toArray(new Integer[result.size()]);
        return  array;
    }
}
