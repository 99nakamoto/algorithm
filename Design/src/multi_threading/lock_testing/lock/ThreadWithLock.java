package multi_threading.lock_testing.lock;

import multi_threading.lock_testing.MyInt;

public class ThreadWithLock implements Runnable {

	MyInt myInt = null;
    String threadName;
    public boolean finished = false;

	public ThreadWithLock(String name, MyInt mint) {
		threadName = name;
        myInt = mint;
	}

	@Override
	public void run() {
        synchronized (myInt) {
            for (int i = 0; i < 100; i++) {
                myInt.num++;
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(threadName + " set number to " + myInt.num);
        finished = true;
	}

}
