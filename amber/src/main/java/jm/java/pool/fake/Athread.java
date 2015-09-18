package jm.java.pool.fake;

/**
 * Created by Roger on 2015/9/15.
 */
public class Athread implements Runnable{
    private String name;
    public Athread(String name){
        this.name = name;
    }

    @Override
    public void run() {
        synchronized (this){
            String name = Thread.currentThread().getName();
            System.out.println("I am : " +name);
        }
    }
}
