package multi_threading.lock_testing.nolock;

import multi_threading.lock_testing.MyInt;

public class Testing {
	public static void main(String args[]) throws InterruptedException {

		MyInt myInt = new MyInt(0);

        ThreadNoLock thread1 = new ThreadNoLock("thread1", myInt);
        ThreadNoLock thread2 = new ThreadNoLock("thread2", myInt);
        ThreadNoLock thread3 = new ThreadNoLock("thread3", myInt);

		new Thread(thread1).start();
        new Thread(thread2).start();
        new Thread(thread3).start();

        while (!thread1.finished || !thread2.finished || !thread3.finished) {
            Thread.sleep(300);
        }
            System.out.println("finally = " + myInt.num);
	}
}
