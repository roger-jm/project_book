package com.jm.java.executor;

import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.Executor;

import static com.jm.java.executor.Simple.*;
import static org.junit.Assert.*;

/**
 * This is Project project_book
 * Created by jmwmj
 * On 2015/7/28
 * At 9:47
 */
public class SimpleTest {
    Simple simple;
    @Before
    public void init(){
        simple = new Simple();
    }

    @Test
    public void testCreateExecutor() throws Exception {
        Executor executor = simple.createExecutor();
        //executor.execute(new Simple.CountPlus());

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}