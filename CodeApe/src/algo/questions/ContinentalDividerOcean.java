package algo.questions;
import java.util.LinkedList;
import java.util.Queue;

import common.Pair;

public class ContinentalDividerOcean {

	public static void main(String[] args) {
		ContinentalDividerOcean ins = new ContinentalDividerOcean();
		long startTime = System.currentTimeMillis();

		System.out.println("Code Ape Run... ");
		int[][] map = new int[][] { { 0, 0, 0, 1, 2, 3, 0 },
				{ 0, 1, 2, 2, 4, 3, 2 }, { 2, 1, 1, 3, 3, 2, 0 },
				{ 0, 3, 3, 3, 2, 3, 3 } };
		ins.findSuperPeak(map);

		System.out.print("Total time = ");
		System.out.print((System.currentTimeMillis() - startTime) / 1000.0);
	}

	public void findSuperPeak(int[][] map) {
		int m = map.length;
		int n = map[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (check(map, new Pair(i, j), m, n)) {
					System.out.println("Found point (" + i + ", " + j
							+ ") with height of " + map[i][j]);
				}
			}
		}
	}

	private boolean check(int[][] originalMap, Pair p, int m, int n) {
		// check if point can flow to all oceans
		if (originalMap[p.x][p.y] == 0) {
			return false;
		}

		int[][] map = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = originalMap[i][j];
			}
		}

		Queue<Pair> q = new LinkedList<Pair>();
		q.offer(p);

		while (!q.isEmpty()) {
			Pair top = q.poll();
			int x = top.x;
			int y = top.y;
			if (map[x][y] == -1) {
				continue;
			}
			// add neighbor nodes who are visitable from here
			if (x - 1 >= 0 && map[x - 1][y] <= map[x][y]) {
				// water can flow from:
				// 1. high altitude to lower
				// 2. from ocean to ocean
				q.offer(new Pair(x - 1, y));
			}
			if (x + 1 < m && map[x + 1][y] <= map[x][y]) {
				q.offer(new Pair(x + 1, y));
			}
			if (y - 1 >= 0 && map[x][y - 1] <= map[x][y]) {
				q.offer(new Pair(x, y - 1));
			}
			if (y + 1 < n && map[x][y + 1] <= map[x][y]) {
				q.offer(new Pair(x, y + 1));
			}

			// visit this point
			map[x][y] = -1;
		}

		// now we finished BFS and the entire map with lower altitude is visited
		// (including all ocean points). We now check if there exists a 0 in map
		for (int[] arr : map)
			for (int i : arr)
				if (i == 0) // found an unvisited ocean point
					return false;
		return true;
	}
}
