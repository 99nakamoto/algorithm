package algo.questions;
public class ScheduleingJobsWithMaxCost {

	private static final int SIZE = 5;

	public static void main(String[] args) {
		ScheduleingJobsWithMaxCost ins = new ScheduleingJobsWithMaxCost();

		Job[] jobs = new Job[SIZE];
		jobs[0] = new Job(1, 5, 500);
		jobs[1] = new Job(2, 4, 5000);
		jobs[2] = new Job(4, 8, 50000);
		jobs[3] = new Job(5, 7, 50);
		jobs[4] = new Job(7, 8, 0);

		System.out.println("answer 1: " + ins.dpSolution(jobs, SIZE)
				+ " should be 55000");
		System.out.println("answer 1: " + ins.recursiveSolution(jobs, 5, 0)
				+ " should be 55000");

		jobs[4].cost = 100000;
		System.out.println("answer 2: " + ins.dpSolution(jobs, SIZE)
				+ " should be 105050");
		System.out.println("answer 2: " + ins.recursiveSolution(jobs, 5, 0)
				+ " should be 105050");

		jobs[0].cost = 70000;
		System.out.println("answer 3: " + ins.dpSolution(jobs, SIZE)
				+ " should be 170050");
		System.out.println("answer 3: " + ins.recursiveSolution(jobs, 5, 0)
				+ " should be 170050");
	}

	private int dpSolution(Job[] jobs, int size) {
		int[] dp = new int[size];
		dp[size - 1] = jobs[size - 1].cost;
		// cost of last job equals to just itself
		for (int k = size - 2; k >= 0; k--) {
			int next = findNextJob(jobs, k);
			int includeK = jobs[k].cost;
			if (next < size) {
				includeK += dp[next];
			}
			int excludeK = dp[k + 1];
			dp[k] = Math.max(includeK, excludeK);
		}
		return dp[0];
	}

	public int recursiveSolution(Job[] jobs, int size, int k) {
		// max cost from (k)th job and onwards
		if (k == size) {
			return 0;
		}
		// (k)th job must not conflict with any previous job
		int next = findNextJob(jobs, k);
		int includeK = jobs[k].cost + recursiveSolution(jobs, size, next);
		int excludeK = recursiveSolution(jobs, size, k + 1);
		return Math.max(includeK, excludeK);
	}

	private int findNextJob(Job[] jobs, int k) {
		int finishTime = jobs[k].finish;
		int next = k + 1;
		while (next < jobs.length) {
			if (jobs[next].start < finishTime) {
				next++;
			} else {
				break;
			}
		}
		return next;
	}
}

class Job {
	int start;
	int finish;
	int cost;

	public Job(int a, int b, int c) {
		this.start = a;
		this.finish = b;
		this.cost = c;
	}
}
