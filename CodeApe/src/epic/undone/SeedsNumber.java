package epic.undone;

public class SeedsNumber {

	public static void main(String[] args) {
		SeedsNumber ins = new SeedsNumber();

		ins.doIt(24);
		ins.doIt(39);
		ins.doIt(1716);
		System.out.println();

		ins.printAllSeeds(24);
		ins.printAllSeeds(39);
		ins.printAllSeeds(1716);

	}

	private void printAllSeeds(int num) {
		if (num == 1) {
			System.out.println("1");
			return;
		}
		for (int i = 10; i <= num / 2; i++) {
			// check if i is a seed of num
			int seed = i;
			long product = seed;
			while (seed > 10) {
				product *= seed % 10;
				seed /= 10;
			}
			product *= seed;
			if (product == num) {
				System.out.println("seed found: " + i);
			}
		}
	}

	private void doIt(int num) {

		int product = 1;
		int seed = 1;

		while (seed <= (num * 0.5)) {
			if (num % seed == 0) {
				int factor = seed;
				product = factor;
				while (!(factor == 0)) {
					int mod = factor % 10;
					factor = factor / 10;
					product *= mod;
				}
				if (product == num) {
					System.out.println("The seed of " + num + " is: " + seed);
					return;
				}
			}
			seed++;
		}
	}
}
