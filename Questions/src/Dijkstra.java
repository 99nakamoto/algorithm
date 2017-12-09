import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Dijkstra {

	private static Random rand = new Random();
	private static int[][] matrix;
	private static Map<Integer, Integer> distances;

	public static int[][] randomMatrix(int size) {
		matrix = new int[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = i + 1; j < size; j++) {
				matrix[i][j] = rand.nextInt(20) + 1;
				if (i == 0) {
					// Applies weight, otherwise, the final distance is usually
					// the same as the first row.
					matrix[i][j] += (j - 1) * 15;
				}
			}
		}
		return matrix;
	}

	public static void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length - 1; j++) {
				System.out.print(Math.abs(matrix[i][j]) + ", ");
			}
			System.out.println(matrix[i][matrix[i].length - 1]);
		}
		System.out.println("-----------------------------");
	}

	public static void minPath() throws RuntimeException {
		distances = new HashMap<Integer, Integer>();
		distances.put(0, 0);
		for (int i = 0; i < matrix.length; i++) {
			for (int j = i + 1; j < matrix[i].length; j++) {
				if (matrix[i][j] == 0) {
					// not connected
					continue;
				}
				if (distances.get(j) == null) {
					distances.put(j, distances.get(i) + matrix[i][j]);
				} else {
					if (distances.get(i) == null) {
						throw new RuntimeException();
					} else {
						if (distances.get(i) + matrix[i][j] < distances.get(j)) {
							distances.put(j, distances.get(i) + matrix[i][j]);
						}
					}
				}
			}
		}
		System.out.println(distances.toString());
	}

	public static void main(String[] args) {

		printMatrix(randomMatrix(5));
		minPath();

		matrix = new int[6][6];
		matrix[0][1] = 7;
		matrix[0][2] = 9;
		matrix[0][5] = 14;
		matrix[1][2] = 10;
		matrix[1][3] = 15;
		matrix[2][3] = 11;
		matrix[2][5] = 2;
		matrix[3][4] = 6;
		matrix[4][5] = 9;

		printMatrix(matrix);
		minPath();
	}

}
