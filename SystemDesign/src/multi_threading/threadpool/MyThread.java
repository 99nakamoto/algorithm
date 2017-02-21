package multi_threading.threadpool;

import multi_threading.blockingQ.implement.MyBlockingQueue;

public class MyThread extends Thread {

	private MyBlockingQueue taskQueue = null;
	private boolean isStopped = false;

	public MyThread(MyBlockingQueue queue) {
		taskQueue = queue;
	}

	public void run() {
		while (!isStopped()) {
			try {
				Runnable runnable = (Runnable) taskQueue.dequeue();
				runnable.run();
			} catch (Exception e) {
				// log or otherwise report exception,
				// but keep pool thread alive.
			}
		}
	}

	public synchronized void stopMyThread() {
		isStopped = true;
		this.interrupt(); // break pool thread out of dequeue() call.
	}

	public synchronized boolean isStopped() {
		return isStopped;
	}
}