package jm.java.pool.fake;

import java.util.concurrent.Callable;

/**
 * Created by Roger on 2015/9/15.
 */
public class Acall implements Callable<String> {
    private final int count;

    public Acall(int count){
        this.count = count;
    }
    @Override
    public String call() throws Exception {
        return "I am a poor man"+count + "!";
    }
}
