package com.java.custom.collection.impl;

import com.java.custom.collection.Stack;

/**
 * Created by Roger on 2015/9/11.
 */
public class FixStack<E> implements Stack<E> {
    protected Object[] elements;
    private int count = 0;

    public FixStack(){
        elements = new Object[10];
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public E push(E o) {
        elements[count++]=o;
        return o;
    }

    @Override
    public E pop() {
        int index = count - 1;
        E e = (E) elements[index];
        elements[--count] = null;
        return e;
    }
}
