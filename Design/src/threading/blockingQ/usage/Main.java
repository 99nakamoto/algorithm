package threading.blockingQ.usage;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {

	// original post from:
	// http://www.journaldev.com/1034/java-blockingqueue-example-implementing-producer-consumer-problem

	private static final Setting testFullQueue = new Setting(3, 10, 0);
	private static final Setting testEmptyQueue = new Setting(10, 3, 100);

	public static void main(String[] args) {

		// Creating BlockingQueue of size 5
		BlockingQueue<Message> queue = new ArrayBlockingQueue<>(5);

		Setting variableSetting = testFullQueue;
		Producer producer = new Producer(queue, variableSetting.produceSpeed);
		Consumer consumer = new Consumer(queue, variableSetting.consumeSpeed,
				variableSetting.consumerDelay);

		// starting producer to produce messages in queue
		new Thread(producer).start();

		// starting consumer to consume messages from queue
		new Thread(consumer).start();

		System.out.println("Producer and Consumer has been started");
	}

	static class Setting {
		int produceSpeed;
		int consumeSpeed;
		int consumerDelay;

		public Setting(int a, int b, int c) {
			this.produceSpeed = a;
			this.consumeSpeed = b;
			this.consumerDelay = c;
		}
	}
}