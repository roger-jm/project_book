package com.jm.java.generics;

/**
 * This is Project project_book
 * Created by jmwmj
 * On 2015/7/28
 * At 16:08
 */
public class WrapProduct<E> {
    private E product;
    public E getProduct(){
        return product;
    }

    public WrapProduct(E product){
        this.product = product;
    }
    public void print(){

    }
}
