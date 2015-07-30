package com.jm.java.generics.connection;

import java.util.logging.Logger;

/**
 * This is Project project_book
 * Created by jmwmj
 * On 2015/7/29
 * At 10:54
 */
public class Astack<T> {
    Logger logger = Logger.getLogger("log");

    private int index = -1;
    private int size = 10;
    private int limit = -1;

    Object[] stack = null;

    public Astack(int coreSize,int limit){
        this.size = coreSize;
        this.limit = limit;
        stack = new Object[size];
    }

    public void push(T obj){
        index++;
        if(limit !=-1 && index>limit){
            logger.info("over the limit!");
            index--;
            return;
        }
        if(index >= size){
            expand(10);
            stack[index] = obj;
        }else{
            stack[index] = obj;
        }
    }

    public T pop(){
        if(index<0){
            return null;
        }
        T obj = (T)stack[index];
        stack[index]=null;
        index--;
        return obj;
    }

    public void clear(){
        if(index<0){
            return;
        }
        for(int i=0;i<getSize();i++){

            stack[i] = null;
        }
        index = -1;
    }

    private void expand(int addition){
        int capacity = size + addition;
        Object[] newStack = new Object[capacity];
        System.arraycopy(stack,0,newStack,0,size);
        stack = newStack;
        size = capacity;
    }

    public int getSize(){
        return index+1;
    }

    public int getCapacity(){
        return stack.length;
    }
}
