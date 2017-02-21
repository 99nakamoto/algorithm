package design_questions.monitorRps;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MonitoringThread implements Runnable {

	String name;
	List<Long> listRequests;

	int last200ms = -1;
	int last1s = -1;
	int last5s = -1;

	boolean forceStop;

	public MonitoringThread(String threadName) {
		name = threadName;
		listRequests = new ArrayList<Long>();
		forceStop = false;
	}

	@Override
	public void run() {
		// every second, print 3 speeds:
		while (!forceStop) {

			long timestamp = new Date().getTime();
			// update last200ms
			while (last200ms >= 0
					&& timestamp - listRequests.get(last200ms) >= 200) {
				last200ms--;
			}
			// update last1s
			while (last1s >= 0 && timestamp - listRequests.get(last1s) >= 1000) {
				last1s--;
			}
			// update last5s
			while (last5s >= 0 && timestamp - listRequests.get(last5s) >= 5000) {
				listRequests.remove(last5s);
				last5s--;
			}

			System.out.println("Speed: " + (last200ms + 1) + "/200ms "
					+ (last1s + 1) + "/s " + (last5s + 1) + "/5s");
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void process(long timestamp) {

		// a new request comes, so we put it on the head of listRequests
		listRequests.add(0, timestamp);
		// System.out.println("processing .... " + timestamp % 100000);

		// advance all pointers by 1 position
		last200ms++;
		last1s++;
		last5s++;

	}

	public void forceStop() {
		forceStop = true;
	}
}
