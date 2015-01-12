package threading.blockingq.example1;

import java.util.concurrent.BlockingQueue;

import threading.blockingq.example1.ProducerConsumerService.Setting;

public class Producer implements Runnable {

	private BlockingQueue<Message> queue;
	int produceSpeed;

	public Producer(BlockingQueue<Message> q, int a) {
		this.queue = q;
		this.produceSpeed = a;
	}

	@Override
	public void run() {
		// produce messages
		for (int i = 0; i < 13; i++) {
			Message msg = new Message("" + i);
			try {
				Thread.sleep(produceSpeed);
				queue.put(msg);
				System.out.println("Produced " + msg.getMsg() + "           ("
						+ queue.size() + " items)");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		// adding exit message
		Message msg = new Message("exit");
		try {
			queue.put(msg);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}