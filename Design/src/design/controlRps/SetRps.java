package design.controlRps;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class SetRps {

	// limit the request per second of a large incoming stream of requests

	AtomicInteger count = new AtomicInteger(0);
	int limit = -1;
	int printIndex = 1;
	long startTimestamp = -1;

	void setRPS(int num) {
		limit = num;
	}

	boolean process(long timestamp) {
		// suppose timestamp is ms
		synchronized (this) {
			if (count.get() < limit) {
				// can process
				count.incrementAndGet();
				System.out.println(printIndex++ + ". processing request "
						+ timestamp % 100000 / 1000 + "," + timestamp % 1000);
				return true;
			}
			if (timestamp - startTimestamp >= 1000) {
				// every 1 seconds, reset
				count.set(0);
				startTimestamp = timestamp;
				System.out.println("clear!");
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) throws InterruptedException {

		// try to use prime number for RpsInput, and a small RpsLimit
		runFor5seconds(11, 4);
		runFor5seconds(55, 5);
		runFor5seconds(100, 9);

	}

	private static void runFor5seconds(int RpsInput, int RpsLimit)
			throws InterruptedException {
		SetRps ins = new SetRps();
		ins.setRPS(RpsLimit);
		System.out.println("start test with " + RpsInput + "/s input and "
				+ RpsLimit + "/s limit");

		long startTime = System.currentTimeMillis();

		for (int i = 0; i < 5 * RpsInput; i++) {
			Date date = new Date();
			long timestamp = date.getTime();
			ins.process(timestamp);
			Thread.sleep(1000 / RpsInput);
			// generate xxx request every second
		}

		System.out.println("done");
		System.out.print("Total time = ");
		System.out.print((System.currentTimeMillis() - startTime) / 1000.0);
		System.out.println(" seconds. ");
		System.out.println("done");
	}
}
