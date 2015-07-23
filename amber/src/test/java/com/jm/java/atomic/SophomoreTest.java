package com.jm.java.atomic;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import static org.junit.Assert.*;

/**
 * This is Project project_book
 * Created by jmwmj
 * On 2015/7/22
 * At 15:11
 */
public class SophomoreTest {

    @Test
    public void testLong(){
        AtomicLong al = new AtomicLong();
        al.addAndGet(100l);
        long l = al.get();
        System.out.println(al.doubleValue());
        System.out.println(l);
    }

    @Test
    public void testInt(){
        AtomicInteger ai = new AtomicInteger();

    }

}