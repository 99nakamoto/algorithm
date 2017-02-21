package multi_threading.lock_testing.nolock;

import multi_threading.lock_testing.MyInt;

public class ThreadNoLock implements Runnable {

	MyInt myInt = null;
    String threadName;
    public boolean finished = false;

	public ThreadNoLock(String name, MyInt mint) {
		threadName = name;
        myInt = mint;
	}

	@Override
	public void run() {
        for (int i = 0; i < 100; i++) {
            myInt.num++;
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(threadName + " set number to " + myInt.num);
        finished = true;
	}

}
