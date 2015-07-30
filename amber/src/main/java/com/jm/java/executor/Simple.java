package com.jm.java.executor;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * This is Project project_book
 * Created by jmwmj
 * On 2015/7/28
 * At 9:20
 */
public class Simple {
    private int coreSize = 25;
    private int maxSize = 200;
    long keepAliveTime = 60000;
    int maxQueueSize = Integer.MAX_VALUE;

    LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>(maxQueueSize);

//ThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue)
    public Executor createExecutor(){
        Executor executor = new ThreadPoolExecutor(coreSize,maxSize,keepAliveTime, TimeUnit.MILLISECONDS,queue);
        return executor;
    }

    protected class CountPlus implements Runnable{

        volatile int count = 0;

        @Override
        public void run() {
            System.out.println("i am number: " + count++);
        }
    }
}
