package com.javarush.task.task37.task3707;

import java.io.*;
import java.util.*;

public class AmigoSet<E> extends AbstractSet<E> implements Serializable, Cloneable, Set<E> {

    private static final Object PRESENT= new Object();
    private transient HashMap<E,Object> map;

    public AmigoSet() {
        map=new HashMap<>();
    }

    public AmigoSet(Collection<? extends E> collection) {
        map = new HashMap<E, Object>((16 > collection.size()/.75f ? 16 : (int)(collection.size()/.75f + 1)));
        addAll(collection);
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeFloat(HashMapReflectionHelper.callHiddenMethod(map, "loadFactor"));
        out.writeInt(HashMapReflectionHelper.callHiddenMethod(map, "capacity"));
        out.writeInt(map.size());
        for (E entry: map.keySet()){
            out.writeObject(entry);
        }
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        Float loadFactor = in.readFloat();
        int capacity = in.readInt();
        int size = in.readInt();
        map = new HashMap<E, Object>(capacity, loadFactor);
        for (int i = 0; i < size; i++){
            map.put((E) in.readObject(), PRESENT);
        }


    }

    public Object clone(){
        try {
            HashMap<E, Object> newMap = (HashMap<E, Object>) map.clone();
            AmigoSet<E> newAmigoSet = new AmigoSet<E>();
            newAmigoSet.map = newMap;
            return newAmigoSet;
        }catch (Exception ex){
            throw new InternalError();
        }
    }

    @Override
    public Iterator<E> iterator() {
        return map.keySet().iterator();
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean remove(Object o) {
        return super.remove(o);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    @Override
    public boolean add(E e) {
        return map.put(e, PRESENT) == null;
    }


}
