package com.jm.java.autbox;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * This is Project project_book
 * Created by jmwmj
 * On 2015/7/29
 * At 15:32
 */
public class SimpleTest {

    @Test
    public void testFreshmen() throws Exception {
        Integer a = 10;
        Integer b = 10;
        Integer aa = new Integer(20);
        Integer bb = new Integer(20);
        assertEquals(a,b);
        assertEquals(aa,bb);
        assertSame(a,b);
        //assertSame(aa,bb);
        assertTrue(a==b);
        assertTrue(aa!=bb);
    }

    @Test
    public void test1() throws Exception {
        String ss = "";
        ss =  ss.equals("")?"a":"b";
    }
}