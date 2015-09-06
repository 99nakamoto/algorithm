package multi_threading.lock;

/**
 * Created by ran on 6/9/15.
 */
public class Lock{
    // http://tutorials.jenkov.com/java-concurrency/locks.html

    private boolean isLocked = false;

    public synchronized void lock()
            throws InterruptedException{
        while(isLocked){
            wait();          // important
        }
        isLocked = true;
    }

    public synchronized void unlock(){
        isLocked = false;
        notify();            // important
    }
}