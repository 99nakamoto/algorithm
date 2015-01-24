package threading.blockingq.example2;

public class Producer implements Runnable {

	protected MyBlockingQueue queue = null;

	public Producer(MyBlockingQueue queue) {
		this.queue = queue;
	}

	public void run() {
		System.out.println("Producer starting... ");
		try {
			for (int i = 1; i <= 5; i++) {
				queue.enqueue("" + i);
				Thread.sleep(500);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}