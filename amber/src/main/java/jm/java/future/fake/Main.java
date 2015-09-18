package jm.java.future.fake;

import java.util.concurrent.*;

/**
 * Created by Roger on 2015/9/14.
 */
public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        final ArchiveSearcher searcher = new MySearcher();
       /* Future<String> future = executor.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return searcher.search("Thor");
            }
        });*/
        FutureTask<String> future = new FutureTask<String>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return searcher.search("Odin");
            }
        });
        executor.execute(future);
        displayOthers();
        String result;
        try {
            result = future.get();
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
       /* while (Thread.activeCount()>1){
            System.out.println(Thread.activeCount());
        }*/
        //executor.shutdown();
    }

    private static void displayOthers() {
        try {
            System.out.println("I am doing something else");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
