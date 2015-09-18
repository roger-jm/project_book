package com.jm.java.str.vol;

/**
 * Created by Roger on 2015/9/14.
 */
public class VolatileShow {
    private volatile int count = 0;

    private void increase(){
        synchronized (this){
            count++;
        }
    }

    public void doit(){
        for(int i=0;i<100;i++){
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    increase();
                }
            });
            t.start();
        }

    }

    public int getCount(){
        return count;
    }
}
