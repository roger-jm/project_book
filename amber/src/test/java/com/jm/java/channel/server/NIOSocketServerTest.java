package com.jm.java.channel.server;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * This is Project project_book
 * Created by jmwmj
 * On 2015/7/23
 * At 11:02
 */
public class NIOSocketServerTest {

    @Test
    public void testFilecode() throws Exception {
        String code = System.getProperty("file.encoding");
        System.out.println(code);
    }
}