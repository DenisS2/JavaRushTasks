package com.javarush.task.task33.task3310.tests;

import com.javarush.task.task33.task3310.Shortener;
import com.javarush.task.task33.task3310.strategy.*;
import org.junit.*;

public class FunctionalTest {

    @Test
    public void testHashMapStorageStrategy(){
        HashMapStorageStrategy hashMapStorageStrategy = new HashMapStorageStrategy();
        Shortener shortener = new Shortener(hashMapStorageStrategy);
        testStorage(shortener);
    }

    @Test
    public void testOurHashMapStorageStrategy(){
        OurHashMapStorageStrategy ourHashMapStorageStrategy =new OurHashMapStorageStrategy();
        Shortener shortener = new Shortener(ourHashMapStorageStrategy);
        testStorage(shortener);
    }

    @Test
    public void testFileStorageStrategy(){
        FileStorageStrategy fileStorageStrategy = new FileStorageStrategy();
        Shortener shortener = new Shortener(fileStorageStrategy);
        testStorage(shortener);
    }

     @Test
     public void testHashBiMapStorageStrategy(){
         HashBiMapStorageStrategy hashBiMapStorageStrategy = new HashBiMapStorageStrategy();
        Shortener shortener = new Shortener(hashBiMapStorageStrategy);
        testStorage(shortener);
    }

    @Test
    public void testDualHashBidiMapStorageStrategy(){
        DualHashBidiMapStorageStrategy dualHashBidiMapStorageStrategy = new DualHashBidiMapStorageStrategy();
        Shortener shortener = new Shortener(dualHashBidiMapStorageStrategy);
        testStorage(shortener);
    }

    @Test
    public void testOurHashBiMapStorageStrategy(){
        OurHashBiMapStorageStrategy ourHashBiMapStorageStrategy=new OurHashBiMapStorageStrategy();
        Shortener shortener = new Shortener(ourHashBiMapStorageStrategy);
        testStorage(shortener);
    }

    public void testStorage(Shortener shortener){

        String s1= new String("Helllo");
        String s2= new String("JavaRush");
        String s3= new String("Helllo");

        long id1=shortener.getId(s1);
        long id2=shortener.getId(s2);
        long id3=shortener.getId(s3);

        Assert.assertNotEquals(id1,id2);
        Assert.assertNotEquals(id2,id3);

        Assert.assertEquals(id1,id3);

        String r1=shortener.getString(id1);
        String r2=shortener.getString(id2);
        String r3=shortener.getString(id3);

        Assert.assertEquals(r1,s1);
        Assert.assertEquals(r2,s2);
        Assert.assertEquals(r3,s3);
    }

}
