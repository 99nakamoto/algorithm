package multi_threading.race_condition;

import java.util.concurrent.atomic.AtomicInteger;

class MyInt {
    int num;
    int numSync;
    AtomicInteger numAtom;

    public MyInt(int n) {
        num = n;
        numSync = n;
        numAtom = new AtomicInteger(n);
    }

    public void increase() {
        num++;
    }

    public synchronized void increaseSync() {
        numSync++;
    }

    public void increaseAtom() {
        numAtom.incrementAndGet();
    }
}