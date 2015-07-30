package com.jm.java.inner;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * This is Project project_book
 * Created by jmwmj
 * On 2015/7/28
 * At 11:03
 */
public class ClassBTest {
    private ClassB b = null;
    @Before
    public void init(){
        b = new ClassB();
    }

    @Test
    public void testInvokeInner() throws Exception {
        b.invokeInner();
    }
}