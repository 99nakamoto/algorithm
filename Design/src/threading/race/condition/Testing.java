package threading.race.condition;

import java.util.concurrent.atomic.AtomicInteger;

public class Testing {
	public static void main(String args[]) {

		MyInt myInt = new MyInt(0);

		IncrementThread thread1 = new IncrementThread(myInt);
		IncrementThread thread2 = new IncrementThread(myInt);
		new Thread(thread1).start();
		new Thread(thread2).start();

		System.out.println("End value " + myInt.num);
	}

	static class MyInt {
		int num;
		int numSync;
		AtomicInteger numAtom;

		public MyInt(int n) {
			num = n;
			numSync = n;
			numAtom = new AtomicInteger(n);
		}

		public void increase() {
			num++;
		}

		public synchronized void increaseSync() {
			numSync++;
		}

		public void increaseAtom() {
			numAtom.incrementAndGet();
		}
	}
}