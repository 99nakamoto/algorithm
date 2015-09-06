package multi_threading.race_condition;

public class IncrementThread implements Runnable {

	MyInt myInt = null;

	public IncrementThread(MyInt mint) {
		myInt = mint;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			myInt.increase();
			myInt.increaseSync();
			myInt.increaseAtom();

			System.out.println("num = " + myInt.num + "; numSync = "
					+ myInt.numSync + "; numAtom is "
					+ myInt.numAtom.intValue());
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
