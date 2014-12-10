package epic.undone;

public class SeedsNumber {

	public static void main(String[] args) {
		SeedsNumber ins = new SeedsNumber();
		
		ins.doIt();
		
		System.out.println();
	}

	private void solution() {

	}

	private void doIt() {

		int num = 1716;

		int product = 1;
		int seed = 1;

		while (seed < (num * 0.5)) {
			if (num % seed == 0) {
				int factor = seed;
				product = factor;
				while (!(factor == 0)) {
					int mod = factor % 10;
					factor = factor / 10;
					product *= mod;
				}
				if (product == num) {
					System.out.println("\nThe seed of " + num + " is: " + seed);
					return;
				}
			}
			seed++;
		}
	}
}
