package com.java.custom.collection;

/**
 * Created by Roger on 2015/9/11.
 */
public interface Stack<E> {
    int size();

    boolean isEmpty();

    E push(E t);

    E pop();
}
