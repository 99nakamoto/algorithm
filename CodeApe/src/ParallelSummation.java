import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ParallelSummation {

	public static void main(String[] args) {
		int cpus = Runtime.getRuntime().availableProcessors();
		// would keep this of other tasks as well.
		ExecutorService service = Executors.newFixedThreadPool(cpus);

		final float[] floats = new float[100];
		for (int i = 0; i < floats.length; i++) {
			// generate random values
			floats[i] = (float) ((int) (1000 * Math.random()) / 10.0);
		}

		List<Future<Double>> tasks = new ArrayList<>();
		int blockSize = (floats.length + cpus - 1) / cpus;

		for (int i = 0; i < floats.length; i++) {
			final int start = blockSize * i;
			final int end = Math.min(blockSize * (i + 1), floats.length);
			Callable c = new Callable<Double>() {
				public Double call() {
					double d = 0;
					for (int j = start; j < end; j++)
						d += floats[j];
					return d;
				}
			};
			tasks.add(service.submit(c));
		}

		double sum = 0;
		for (Future<Double> task : tasks) {
			try {
				sum += task.get();
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("sum is " + sum);
	}
}
