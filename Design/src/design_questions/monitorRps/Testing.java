package design_questions.monitorRps;

import java.util.Date;

public class Testing {

	public static void main(String[] args) {
		Testing ins = new Testing();
		long startTime = System.currentTimeMillis();

		System.out.println("Code Ape Run... ");

		MonitoringThread thread = new MonitoringThread("Thread1");
		new Thread(thread).start();

		ins.startRequestVariableRate(thread, 3, 200, 5);
		ins.startRequestVariableRate(thread, 1300, -300, 5);

		// ins.startRequestConstantRate(thread, 9, 7);
		// // run 7 seconds with constant rate of 9
		//
		// ins.startRequestVariableRate(thread, 3, 4, 7);
		// // rps = 3, 7, 11, 15, 19, 23, 27
		//
		// ins.startRequestVariableRate(thread, 131, -15, 6);
		// // rps = 131， 116, 101, 86, 71, 56

		thread.forceStop();

		System.out.print("Total time = ");
		System.out.print((System.currentTimeMillis() - startTime) / 1000.0);
	}

	public void startRequestConstantRate(MonitoringThread thread, int rps,
			int runSeconds) {
		System.out.println("Run " + runSeconds
				+ " seconds with constant rate of " + rps + " r/s...");

		for (int i = 0; i < runSeconds; i++) {
			runOneSecGivenRps(thread, rps);
		}
		System.out.println();
	}

	public void startRequestVariableRate(MonitoringThread thread, int initRps,
			int rpsChange, int runSeconds) {
		System.out.println("Run " + runSeconds
				+ " seconds with initial rate of " + initRps + " r/s & "
				+ "each second rps increase by " + rpsChange);

		for (int i = 0; i < runSeconds; i++) {
			runOneSecGivenRps(thread, initRps + i * rpsChange);
		}
		System.out.println();
	}

	private void runOneSecGivenRps(MonitoringThread thread, int rps) {
		for (int i = 0; i < rps; i++) {
			thread.process(new Date().getTime());
			try {
				Thread.sleep(1000 / rps);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
