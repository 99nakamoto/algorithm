package multi_threading.multiserver.message_eachother;

import java.util.ArrayList;
import java.util.List;

public class Main {

    // In this project, a group of servers will send message to each other
    // One server sends, and all other server can see the message.

	public static void main(String[] args) throws InterruptedException {
		Main ins = new Main();
		long startTime = System.currentTimeMillis();

		System.out.println("Code Ape Run... ");

		// setup data
		List<MessagingServer> servers = new ArrayList<MessagingServer>();
		for (int i = 0; i <= 4; i++) {
			servers.add(new MessagingServer("Server" + (i + 1), servers, 5));
			new Thread(servers.get(i)).start();
		}

		// start to test
		Thread.sleep(600);
		servers.get(1).sendMessage("Hello world");

		Thread.sleep(600);
		System.out.println();
		servers.get(2).sendMessage("If you going to San Fransisco");

		Thread.sleep(600);
		System.out.println();
		servers.get(3).sendMessage("Be Sure to Wear Flowers in Your Hair");

		// end test
		for (MessagingServer server : servers) {
			server.terminate();
		}
		Thread.sleep(600);
		System.out.println();

		System.out.print("Total time = ");
		System.out.print((System.currentTimeMillis() - startTime) / 1000.0);
	}

	public void solve(int A) {

	}
}
