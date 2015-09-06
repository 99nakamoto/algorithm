package multi_threading.lock;

public class IncrementThread implements Runnable {

	MyInt myInt = null;

	public IncrementThread(MyInt mint) {
		myInt = mint;
	}

	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {
			myInt.increaseNoLock();
			myInt.increaseWithLock();
			myInt.increaseBuiltInLock();

			System.out.println("num1 = " + myInt.num1 + "; num2 = "
					+ myInt.num2 + "; num3 is " + myInt.num3);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
