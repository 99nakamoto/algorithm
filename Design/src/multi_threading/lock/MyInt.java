package multi_threading.lock;

import java.util.concurrent.atomic.AtomicInteger;

class MyInt {

    int num1;
    int num2;
    int num3;
    private Lock lock = new Lock();

    public MyInt(int n) {
        num1 = n;
        num2 = n;
        num3 = n;
    }

    public void increaseNoLock() {
        num1++;
    }

    public void increaseWithLock() {
        try {
            lock.lock();
            num2++;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void increaseBuiltInLock() {
        synchronized (this) {
            num3++;
        }
    }
}