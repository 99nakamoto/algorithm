package multi_threading.lock_reentry;

/**
 * Created by ran on 6/9/15.
 */
public class LockReentrant {
    // http://tutorials.jenkov.com/java-concurrency/locks.html

    boolean isLocked = false;
    Thread  lockedBy = null;
    int     lockedCount = 0;

    public synchronized void lock()
            throws InterruptedException{
        Thread callingThread = Thread.currentThread();
        while(isLocked && lockedBy != callingThread){
            wait();
        }
        isLocked = true;
        lockedCount++;
        lockedBy = callingThread;
    }

    public synchronized void unlock(){
        if(Thread.currentThread() == this.lockedBy){
            lockedCount--;

            if(lockedCount == 0){
                isLocked = false;
                notify();
            }
        }
    }
}
