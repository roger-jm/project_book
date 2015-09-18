package com.jm.java.str;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Roger on 2015/9/10.
 */
public class StringTestTest {
    @Test
    public void testObject() throws Exception {
        String ss = "amber" + "black" + "cyan" + "denim";
        assertTrue(true);
    }

    @Test
    public void testPlus() throws Exception {
        long b = System.currentTimeMillis();
        String ss = "";
        for (int i=0;i<1000;i++){
            ss+=i;
        }
        System.out.println(System.currentTimeMillis() - b);

    }

    @Test
    public void testBuild() throws Exception {
        long b = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<1000;i++){
            sb.append(i);
        }
        System.out.println(System.currentTimeMillis()-b);

    }

    @Test
    public void test2() throws Exception {
        long b = System.currentTimeMillis();
        for (int i=0;i<200000;i++){
            String ss = "amber" + "black" + "cyan" + "denim";
        }
        System.out.println(System.currentTimeMillis()-b);
    }

    @Test
    public void test3() throws Exception {
        long b = System.currentTimeMillis();
        for (int i=0;i<200000;i++){
           // StringBuilder sb = new StringBuilder();
            StringBuffer sb = new StringBuffer();
            sb.append("amber");
            sb.append("black");
            sb.append("cyan");
            sb.append("denim");
        }
        System.out.println(System.currentTimeMillis()-b);
    }
}