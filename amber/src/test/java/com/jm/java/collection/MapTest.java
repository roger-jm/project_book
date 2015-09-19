package com.jm.java.collection;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by Roger on 2015/9/12.
 */
public class MapTest {

    @Test
    public void testHash() throws Exception {
        Map<String,String> map = new HashMap<>();
        map.put(null,"33");
        map.put(null,"44");
        String ss = map.get(null);
        assertEquals("33", ss);
        assertEquals(2,map.size());
    }

    @Test
    public void testClear() throws Exception {
        Map<String,String> map = new HashMap<>();
        map.put("12","dd");
        map.put("13","dd");
        map.put("14","dd");
        assertEquals(3,map.size());
        map.clear();
        assertEquals(0,map.size());
    }
}
