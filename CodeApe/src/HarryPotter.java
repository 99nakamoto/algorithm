import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class HarryPotter {
	private static Random rand = new Random();
	private static int[][] matrix;
	private static Map<CacheKey, Integer> cache = new HashMap<CacheKey, Integer>();

	static class CacheKey {
		private int x, y;

		public CacheKey(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public boolean equals(Object obj) {
			CacheKey key = (CacheKey) obj;
			return this.x == key.x && this.y == key.y;
		}

		@Override
		public int hashCode() {
			return ((Integer) (this.x + this.y)).hashCode();
		}
	}

	public static int[][] createMatrix(int width, int height) {
		int[][] matrix = new int[height][width];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = rand.nextInt(50);
				if (rand.nextBoolean()) {
					matrix[i][j] *= -1;
				}
			}
		}
		return matrix;
	}

	public static void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			int j = 0;
			for (; j < matrix[i].length - 1; j++) {
				System.out.print(matrix[i][j] + ", ");
			}
			System.out.println(matrix[i][j]);
		}
	}

	public static int minimumStrength(int x, int y) {
		int strength = 0;
		if (x == matrix[0].length - 1 && y == matrix.length - 1) {
			if (matrix[y][x] < 0) {
				strength = -1 * matrix[y][x];
			}
		} else if (x == matrix[0].length - 1) {

			int nextStrength = cachedStrength(x, y + 1);
			strength = calcStrength(nextStrength, x, y);
		} else if (y == matrix[0].length - 1) {
			int nextStrength = cachedStrength(x + 1, y);
			strength = calcStrength(nextStrength, x, y);
		} else {
			int nextStrength = Math.min(cachedStrength(x, y + 1),
					cachedStrength(x + 1, y));
			strength = calcStrength(nextStrength, x, y);
		}
		System.out.println(x + ", " + y + " needs minimum strength of "
				+ strength);
		return strength;
	}

	public static int cachedStrength(int x, int y) {
		CacheKey key = new CacheKey(x, y);
		if (cache.containsKey(key)) {
			return cache.get(key);
		} else {
			int strength = minimumStrength(x, y);
			cache.put(key, strength);
			return strength;
		}
	}

	private static int calcStrength(int nextStrength, int x, int y) {
		int strength = 0;
		if (nextStrength == 0) {
			if (matrix[y][x] < 0)
				strength = -1 * matrix[y][x];
		} else {
			if (matrix[y][x] - nextStrength >= 0) {
				strength = 0;
			} else {
				strength = nextStrength - matrix[y][x];
			}
		}
		return strength;
	}

	public static void main(String[] args) {
		int size = 3;
		matrix = createMatrix(size, size);
		printMatrix(matrix);
		cachedStrength(0, 0);
	}
}
