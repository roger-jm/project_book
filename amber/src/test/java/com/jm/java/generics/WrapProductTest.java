package com.jm.java.generics;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * This is Project project_book
 * Created by jmwmj
 * On 2015/7/28
 * At 16:27
 */
public class WrapProductTest {

    @Test
    public void testPrint() throws Exception {
        Product p = new Product();
        WrapProduct<Product> wrap = new WrapProduct<Product>(p);
        wrap.getProduct();
    }
}