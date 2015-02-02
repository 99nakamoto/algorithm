package threading.threadpool;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		// In this example, we create 3 thread to run 10 tasks
		// set the BlockingQ size to be 5.

		ThreadPool tp = new ThreadPool(3, 5);

		List<MyTask> todoList = new ArrayList<MyTask>();
		for (int i = 1; i <= 10; i++) {
			todoList.add(new MyTask("T" + i));
		}

		for (MyTask todo : todoList) {
			tp.execute(todo);
		}

		while (!tp.noMoreTask()) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		tp.stop();
	}
}
