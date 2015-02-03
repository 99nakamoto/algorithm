import java.util.Date;

public class Testing {

	public static void main(String[] args) {
		Testing ins = new Testing();
		long startTime = System.currentTimeMillis();

		System.out.println("Code Ape Run... ");
		RunningThread t1 = new RunningThread("Thread1");

		t1.process(1111111);
		t1.process(1111111);
		t1.process(1111111);
		t1.process(1111111);
		t1.process(1111111);
		
		t1.run();

		ins.startRequest(t1, 5, 8);

		System.out.print("Total time = ");
		System.out.print((System.currentTimeMillis() - startTime) / 1000.0);
	}

	public void startRequest(RunningThread thread, int rps, int runSeconds) {
		for (int i = 0; i < runSeconds * rps; i++) {
			thread.process(new Date().getTime());
			try {
				Thread.sleep(1000 / rps);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void startRequest(int initRps, int endRps, int runSeconds) {

	}
}
