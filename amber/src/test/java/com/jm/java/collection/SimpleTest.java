package com.jm.java.collection;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

import static org.junit.Assert.*;

/**
 * Created by Roger on 2015/8/17.
 */
public class SimpleTest {
    List<Simple> list = new ArrayList<>();

    @Before
    public void init(){
        list.add(new Simple(3,"Roger3"));
        list.add(new Simple(5,"Roger5"));
        list.add(new Simple(8,"Roger8"));
        list.add(new Simple(0,"wmj"));
        list.add(new Simple(3,"Roger"));
    }

    @Test
    public void testTreeMap(){
        TreeMap<Integer,String> tm = new TreeMap<>();
        tm.put(Integer.valueOf(1),"wmj");
        tm.put(Integer.valueOf(3),"Roger");
        tm.put(Integer.valueOf(3),"Roger3");
        tm.put(Integer.valueOf(5),"Roger5");
        tm.put(Integer.valueOf(8),"Roger8");
        for (String ss : tm.values()){
            System.out.println(ss);
        }
    }

    @Test
    public void testTreeMap2() throws Exception {
        TreeMap<Integer,List<Simple>> map = new TreeMap<>();
        Iterator<Simple> it = list.iterator();
        while(it.hasNext()){
            Simple ss = it.next();
            int num = ss.getNum();
            if(num<0){
                continue;
            }
            if (map.get(num)!=null){
                map.get(num).add(ss);
            }else{
                List<Simple> temp = new ArrayList<>();
                temp.add(ss);
                map.put(num, temp);
            }

        }
        assertEquals(4,map.size());
        for(List<Simple> list : map.values()){
            for (Simple s : list){
                System.out.println(s.getName());
            }
        }
    }
}