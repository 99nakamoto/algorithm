package multi_threading.lock_testing.lock;

import multi_threading.lock_testing.MyInt;

public class Testing {
	public static void main(String args[]) throws InterruptedException {

		MyInt myInt = new MyInt(0);

        ThreadWithLock thread1 = new ThreadWithLock("thread1", myInt);
        ThreadWithLock thread2 = new ThreadWithLock("thread2", myInt);
        ThreadWithLock thread3 = new ThreadWithLock("thread3", myInt);

		new Thread(thread1).start();
        new Thread(thread2).start();
        new Thread(thread3).start();

        while (!thread1.finished || !thread2.finished || !thread3.finished) {
            Thread.sleep(300);
        }
        System.out.println("finally = " + myInt.num);
	}
}
