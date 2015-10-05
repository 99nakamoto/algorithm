package algo.questions;

public class ShortestManhattanDistance {

	public static void main(String[] args) {
		ShortestManhattanDistance ins = new ShortestManhattanDistance();
		long startTime = System.currentTimeMillis();

		System.out.println("Start Run... ");
		
		int[][] input1 = new int[][]{
			new int[]{0, 0, 0, 0, 0},
			new int[]{0, 0, 0, 0, 0},
			new int[]{0, 0, 0, 0, 0},
			new int[]{0, 0, 0, 0, 0},
			new int[]{0, 0, 0, 0, 0},
		};
		ins.findCenter(input1, 0);
		
		input1 = new int[][]{
			new int[]{0, 0, 0, 0, 0},
			new int[]{0, 0, 0, 0, 0},
			new int[]{0, 0, 1, 0, 0},
			new int[]{0, 0, 0, 0, 0},
			new int[]{0, 0, 0, 0, 0},
		};
		ins.findCenter(input1, 0);
		
		input1 = new int[][]{
			new int[]{0, 0, 0, 0, 0},
			new int[]{0, 0, 0, 0, 0},
			new int[]{0, 0, 1, 0, 0},
			new int[]{0, 0, 0, 0, 0},
			new int[]{0, 0, 0, 0, 1},
		};
		ins.findCenter(input1, 0);
		
		input1 = new int[][]{
			new int[]{0, 0, 0, 0, 0},
			new int[]{0, 0, 0, 0, 0},
			new int[]{0, 0, 1, 0, 0},
			new int[]{1, 0, 0, 0, 0},
			new int[]{0, 0, 0, 0, 1},
		};
		ins.findCenter(input1, 0);
		
		input1 = new int[][]{
			new int[]{0, 1, 0, 0, 0},
			new int[]{0, 1, 0, 0, 0},
			new int[]{0, 0, 1, 0, 0},
			new int[]{1, 0, 0, 0, 0},
			new int[]{0, 0, 0, 0, 1},
		};
		ins.findCenter(input1, 0);

		System.out.print("Total time = ");
		System.out.print((System.currentTimeMillis() - startTime) / 1000.0);
	}

	public void findCenter(int[][] input, int numberOfEquip) {
		int m = input.length;
		int n = input[0].length;
		
		// there's gonna be m * n positions
		// we gonna cumulate (numberOfEquip) distances for each position
		int[] dis = new int[m * n];
		
		// from the input map, find Equipments
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (input[i][j] == 1) {
					// 1 represents equipment
					// when found, add the distance to every position
					cumulateDistance(i, j, dis, m, n);
				}
			}
		}
		
		// find the smallest cumulated distance from dis[].
		int sIndex = 0;
		int smallest = dis[0];
		for (int i = 0; i < m * n; i++) {
			if (dis[i] < smallest) {
				smallest = dis[i];
				sIndex = i;
			}
		}
		
		// index sIndex is the final answer
		System.out.println("Answer: " + (sIndex / n) + " " + (sIndex % n));
	}
	
	private void cumulateDistance(int x, int y, int[] dis, int m, int n) {
		for (int i = 0; i < m * n; i++) {
			int a = i / n;
			int b = i % n;
			dis[i] += Math.abs(a - x) + Math.abs(b - y);
		}
	}
}
