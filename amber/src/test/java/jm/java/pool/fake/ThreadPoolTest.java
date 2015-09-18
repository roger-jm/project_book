package jm.java.pool.fake;

import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

import static org.junit.Assert.*;

/**
 * Created by Roger on 2015/9/15.
 */
public class ThreadPoolTest {

    @Test
    public void testExecutor() throws Exception {
        long start = System.currentTimeMillis();
        ExecutorService executor = Executors.newFixedThreadPool(10);
        Set<Future> set = new HashSet<>();
        for(int i=0;i<1000;i++){
            //executor.execute(new Athread("Threadqq-"+Integer.toString(i)));
            Future<String> future = executor.submit(new Acall(i));
            set.add(future);
        }
        //Thread.yield();
        Thread.sleep(3000);
        Iterator<Future> it = set.iterator();
        while (it.hasNext()){
            String ss = (String) it.next().get();
            System.out.println(ss);
        }
       // while (Thread.activeCount()>1);
        System.out.println(System.currentTimeMillis() - start);
    }

    @Test
    public void test1() throws Exception {
        for (int i=0;i<10;i++){
            System.out.println(i);
        }

    }
}