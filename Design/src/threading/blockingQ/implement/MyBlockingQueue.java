package threading.blockingQ.implement;

import java.util.LinkedList;
import java.util.List;

public class MyBlockingQueue {

	private List<Object> queue = new LinkedList<Object>();
	private int size = 10;

	public MyBlockingQueue(int size) {
		this.size = size;
	}

	public synchronized void enqueue(Object item) throws InterruptedException {
		while (this.queue.size() == this.size) {
			wait();
		}
		if (this.queue.size() == 0) {
			notifyAll();
		}
		this.queue.add(item);
	}

	public synchronized Object dequeue() throws InterruptedException {
		while (this.queue.size() == 0) {
			wait();
		}
		if (this.queue.size() == this.size) {
			notifyAll();
		}

		return this.queue.remove(0);
	}

	public boolean isEmpty() {
		return this.queue.isEmpty();
	}
}
