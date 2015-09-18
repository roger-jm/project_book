package com.jm.java.str.vol;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Roger on 2015/9/14.
 */
public class VolatileShowTest {

    @Test
    public void testDoit() throws Exception {
        VolatileShow show = new VolatileShow();
        show.doit();
        while (Thread.activeCount()>2){
            //System.out.println(Thread.activeCount());
        }
        System.out.println("show cout : "+show.getCount());

    }
}