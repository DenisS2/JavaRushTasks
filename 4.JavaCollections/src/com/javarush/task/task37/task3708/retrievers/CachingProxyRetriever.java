package com.javarush.task.task37.task3708.retrievers;

import com.javarush.task.task37.task3708.cache.LRUCache;
import com.javarush.task.task37.task3708.storage.Storage;

public class CachingProxyRetriever implements Retriever{

    Storage storage;
    LRUCache cache = new LRUCache(10000);
    OriginalRetriever originalRetriever;

    public CachingProxyRetriever(Storage storage) {
        this.storage = storage;
        originalRetriever = new OriginalRetriever(storage);
    }


    @Override
    public Object retrieve(long id) {
        Object result;
        result=cache.find(id);
        if (result==null){
            result=originalRetriever.retrieve(id);
            cache.set(id,result);
        }
        return  result;
    }
}
