package com.javarush.task.task33.task3310.strategy;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileBucket {

    private Path path;

    public FileBucket()  {
        try {
            path = Files.createTempFile("Java_Rush_", "_task3310");
            Files.createFile(path);
            Files.deleteIfExists(path);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        path.toFile().deleteOnExit();
    }


    public long getFileSize(){
        long size=0L;
        try {
        size=Files.size(path);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return size;
    }// он должен возвращать размер файла на который указывает path.

    public void putEntry(Entry entry){
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(Files.newOutputStream(path))) {
            objectOutputStream.writeObject(entry);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }// — должен сериализовывать переданный entry в файл. Учти, каждый entry может содержать
    // еще один entry.

    public Entry getEntry(){
        Entry entry = null;

        if (getFileSize() <= 0)
            return entry;

        try (ObjectInputStream objectInputStream = new ObjectInputStream(Files.newInputStream(path))) {
            entry = (Entry) objectInputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return entry;
    }// — должен забирать entry из файла. Если файл имеет нулевой размер,
    // вернуть null.

    public void remove(){
        try {
            Files.delete(path);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }//– удалять файл на который указывает path.
}
