package threading.threadpool;

public class MyTask implements Runnable {

	String message;

	public MyTask(String s) {
		message = s;
	}

	@Override
	public void run() {
		// do some task here...
		// finish the task ...
		System.out.println("Task finished: " + message);
	}

}
