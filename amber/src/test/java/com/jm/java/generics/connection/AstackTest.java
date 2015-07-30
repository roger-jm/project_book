package com.jm.java.generics.connection;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * This is Project project_book
 * Created by jmwmj
 * On 2015/7/29
 * At 11:25
 */
public class AstackTest {
    private Astack<Product> stack = null;

    @Before
    public void init(){
        stack = new Astack<Product>(10,-1);
    }

    @Test
    public void testPush() throws Exception {
        for(int i=0;i<10;i++){
            Product p = new Product(i+1,"w"+i);
            stack.push(p);
        }
        Product p = new Product(11,"wmj");
        stack.push(p);
        System.out.println(stack.getSize());
        System.out.println(stack.getCapacity());

    }

    @Test
    public void testPop() throws Exception {
        testPush();
        int l = stack.getSize();
        for(int i=0;i<l;i++){
            Product p = stack.pop();
            System.out.println(p.toString());
            System.out.println("size:"+stack.getSize());
        }
    }

    @Test
    public void testClear() throws Exception {
        testPush();
        stack.clear();
        System.out.println(stack.getSize());
    }
}