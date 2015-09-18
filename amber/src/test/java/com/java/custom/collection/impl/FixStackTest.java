package com.java.custom.collection.impl;

import org.junit.Before;
import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.*;

/**
 * Created by Roger on 2015/9/11.
 */
public class FixStackTest {
    FixStack<String> stack = null;
    @Before
    public void init(){
         stack = new FixStack<>();
        stack.push("thor");
        stack.push("Iron Man");
    }

    @Test
    public void test(){
        Stack<String> stack = new Stack<>();
        stack.push("thor");
        stack.push("Iron Man");
    }

    @Test
    public void testSize() throws Exception {

    }

    @Test
    public void testIsEmpty() throws Exception {

    }

    @Test
    public void testPush() throws Exception {
        stack.push("amber");
        stack.push("black");
        stack.push("cyan");
        assertEquals(5,stack.size());
    }

    @Test
    public void testPop() throws Exception {
        String hero = stack.pop();
        assertEquals("Iron Man",hero);
        assertEquals(1,stack.size());
    }
}