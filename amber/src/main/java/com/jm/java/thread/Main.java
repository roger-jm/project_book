package com.jm.java.thread;

/**
 * Created by Roger on 2015/9/12.
 */
public class Main {
    public static void main(String[] args) {
        ChildThread childThread = new ChildThread();
        Thread t = new Thread(childThread,"t1");
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
        System.out.println("wait child");
    }

    static class ChildThread implements Runnable{
        @Override
        public void run() {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String name = Thread.currentThread().getName();
            System.out.println("I am : "+name);
            System.out.println("sleep a while!");
            Thread.yield();
            System.out.println("can i output!");
        }
    }
}
