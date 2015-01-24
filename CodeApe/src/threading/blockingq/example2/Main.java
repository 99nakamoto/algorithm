package threading.blockingq.example2;

public class Main {

	public static void main(String[] args) throws Exception {

		MyBlockingQueue queue = new MyBlockingQueue(1024);

		Producer producer = new Producer(queue);
		Consumer consumer = new Consumer(queue);

		new Thread(producer).start();
		new Thread(consumer).start();

		Thread.sleep(4000);
	}
}