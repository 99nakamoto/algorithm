import java.util.ArrayList;
import java.util.List;

public class RunningThread implements Runnable {

	String name;
	List<Long> listRequests;

	int last200ms;
	int last1s;
	int last5s;

	public RunningThread(String threadName) {
		name = threadName;
		listRequests = new ArrayList<Long>();
	}

	@Override
	public void run() {
		// every second, print 3 speeds:
		while (true) {
			System.out.println("Speed: " + last200ms + " " + last1s + " "
					+ last5s);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void process(long timestamp) {

		System.out.println("processing .... " + timestamp);
		// a new request comes, so we put it on the head of listRequests
		listRequests.add(timestamp);
		if (last200ms >= listRequests.size())
			last200ms++;
		if (last1s >= listRequests.size())
			last1s++;
		if (last5s >= listRequests.size())
			last5s++;

		// update last200ms
		while (last200ms > 0 && timestamp - listRequests.get(last200ms) >= 200) {
			last200ms--;
		}
		// update last1s
		while (last1s > 0 && timestamp - listRequests.get(last1s) >= 1000) {
			last1s--;
		}
		// update last5s
		while (last5s > 0 && timestamp - listRequests.get(last5s) >= 1000) {
			listRequests.remove(last5s);
			last5s--;
		}
	}
}
