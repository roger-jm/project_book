package jm.java.future.fake;


/**
 * Created by Roger on 2015/9/14.
 */
public class MySearcher implements ArchiveSearcher {
    @Override
    public String search(String target) {
        /*try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        return "I find the book: " + target;
    }
}
