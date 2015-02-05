package threading.blockingQ.implement;

public class Consumer implements Runnable {

	protected MyBlockingQueue queue = null;

	public Consumer(MyBlockingQueue queue) {
		this.queue = queue;
	}

	public void run() {
		try {
			for (int i = 1; i <= 5; i++) {
				System.out.println(queue.dequeue());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Consumer finished. ");
	}
}
