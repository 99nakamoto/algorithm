package threading.multiserver.messaging;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class MessagingServer implements Runnable {

	String serverId;
	List<MessagingServer> servers;
	BlockingQueue<String> messages;
	boolean isFinished;

	public MessagingServer(String id, List<MessagingServer> list, int qSize) {
		this.serverId = id;
		this.servers = list;
		messages = new ArrayBlockingQueue<String>(qSize);
		isFinished = false;
	}

	public void run() {
		// this would be the consumer
		while (!isFinished) {
			String msg;
			try {
				msg = messages.take();
				System.out.println(serverId + " says: " + msg);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void printMessage(String msg) {
		// this is the producer
		// System.out.println(serverId + " says: " + msg);

		// insert this msg in the blockingQ of all other servers
		for (MessagingServer server : servers) {
			server.messages.add(this.serverId + " said: " + msg);
		}
	}

	public void terminate() {
		this.isFinished = true;
	}
}
