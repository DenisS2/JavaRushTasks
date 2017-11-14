package com.javarush.task.task26.task2611;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by User on 14.06.2017.
 */
public class Producer implements Runnable {

    private ConcurrentHashMap<String, String> map;

    public Producer(ConcurrentHashMap map) {
        this.map = map;
    }

    @Override
    public void run() {
        int i=1;
        while (true){
            try {
                String s="Some text for "+i;
                String is=""+i;
                map.put(is,s);
                i++;
                Thread.sleep(500);
            } catch (InterruptedException e) {
                //System.out.println(Thread.currentThread().getName()+" thread was terminated");
                System.out.println(String.format("[%s] thread was terminated", Thread.currentThread().getName()));
            }
        }

    }
}
