package ru.magomed;

import java.util.Iterator;

public class ArrayIterator<T> implements Iterator<T>{
    private T[] array = null;
    private int index = -1;

    public ArrayIterator(T[] array){
        this.array = array;
    }
    @Override
    public boolean hasNext() {
        return !(array.length - 1 == index || array.length == 0);
    }

    @Override
    public T next() {
        return array[++index];
    }

    public T last(){
        return array[--index];
    }

    public boolean hasLast() {
        return !(0 == index || array.length == 0);
    }

    public T get(){
        return array[index];
    }

}
