package com.javarush.task.task33.task3310.tests;

import com.javarush.task.task33.task3310.Helper;
import com.javarush.task.task33.task3310.Shortener;
import com.javarush.task.task33.task3310.strategy.HashBiMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.HashMapStorageStrategy;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class SpeedTest {

    @Test
    public void testHashMapStorage(){
        Shortener shortener1=new Shortener(new HashMapStorageStrategy());
        Shortener shortener2=new Shortener(new HashBiMapStorageStrategy());
        Set<String> origStrings = new HashSet<>();
        for (int i = 0; i <10000 ; i++) {
            origStrings.add(Helper.generateRandomString());
        }

        Set<Long> ids=new HashSet<>();

        long time1=getTimeForGettingIds(shortener1,origStrings,ids);
        ids=null;
        long time2=getTimeForGettingIds(shortener2,origStrings,ids);
        Assert.assertTrue(time1 > time2);

        origStrings=null;

        time1=getTimeForGettingStrings(shortener1,ids,origStrings);
        origStrings=null;
        time2=getTimeForGettingStrings(shortener2,ids,origStrings);

        Assert.assertEquals(time1, time2, 30);
    }

    public long getTimeForGettingIds(Shortener shortener, Set<String> strings, Set<Long> ids){
        Date start= new Date();
        for (String s:strings) {
            ids.add(shortener.getId(s));
        }
        Date stop = new Date();
        long time=stop.getTime()-start.getTime();
        return time;
    }

    public long getTimeForGettingStrings(Shortener shortener, Set<Long> ids, Set<String> strings){
        Date start= new Date();
        for (long l:ids) {
            strings.add(shortener.getString(l));
        }
        Date stop = new Date();
        long time=stop.getTime()-start.getTime();
        return time;
    }
}
