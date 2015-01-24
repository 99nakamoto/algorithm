package threading.blockingq.example1;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

	private BlockingQueue<Message> queue;
	int consumeSpeed;
	int consumerDelay;

	public Consumer(BlockingQueue<Message> q, int a, int b) {
		this.queue = q;
		this.consumeSpeed = a;
		this.consumerDelay = b;
	}

	@Override
	public void run() {
		try {
			// initial delay: used to wait for producer to
			// fill up the queue
			Thread.sleep(consumerDelay);
			Message msg;
			// consuming messages until exit message is received
			while ((msg = queue.take()).getMsg() != "exit") {
				System.out.println("         " + msg.getMsg() + " Consumed"+ "  ("
						+ queue.size() + " items)");
				Thread.sleep(consumeSpeed);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Consumer finished working. Exit. ");
	}
}