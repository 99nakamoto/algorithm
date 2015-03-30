package palantir.online.y2013;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MeSolution2013 {

	public static void main(String args[]) {

		String inputFile;
		int testCaseNumber = 1;

		while (true) {
			inputFile = "input" + testCaseNumber + ".txt";
			BufferedReader in;
			try {
				URI uri = MeSolution2013.class.getResource(inputFile).toURI();
				in = new BufferedReader(new FileReader(new File(uri)));
			} catch (Exception e) {
				// There is not more test cases
				// Exit.
				break;
			}

			Scanner sc = new Scanner(in);
			int length = sc.nextInt();
			int[][] elevation = new int[length][length];
			for (int i = 0; i < length; i++) {
				for (int j = 0; j < length; j++) {
					elevation[i][j] = sc.nextInt();
				}
			}

			// int length = 5;
			// int[][] elevation = {{1,0,2,5,8},
			// {2,3,4,7,9},
			// {3,5,7,9,9},
			// {1,2,5,5,3},
			// {3,3,5,1,0}};

			// int length = 4;
			// int[][] elevation = {{0,3,2,3},
			// {3,2,1,4},
			// {3,4,3,3},
			// {5,5,2,0}};

			// int length = 3;
			// int[][] elevation = {{1,5,2},
			// {2,4,7},
			// {3,6,9}};

			// int length = 1;
			// int[][] elevation = {{10}};

			List<Pair> sinkList = new ArrayList<Pair>();

			// first find out all sink nodes
			for (int i = 0; i < length; i++) {
				for (int j = 0; j < length; j++) {
					if (elevation[i][j] < lowestNeighbor(i, j, elevation)) {
						// (i,j) is a sink point
						sinkList.add(new Pair(i, j));
					}
				}
			}

			// then for each sink node, return the count
			int[] basinSize = new int[sinkList.size()];
			for (int i = 0; i < sinkList.size(); i++) {
				basinSize[i] = count(sinkList.get(i).X, sinkList.get(i).Y,
						elevation);
			}
			Arrays.sort(basinSize);

			for (int i = sinkList.size() - 1; i >= 0; i--) {
				System.out.print(basinSize[i]);
				if (i != 0)
					System.out.print(" ");
			}
			System.out.println();
			testCaseNumber++;
		}
	}

	static int count(int x, int y, int[][] ele) {

		int num = 1;

		// if the neighbour is higher than current, add count to current count
		// if all neighbours are lower than current, return 1

		// diagonal neighbors
		if (withinBound(x - 1, y, ele) && rainFlowFrom(x, y, x - 1, y, ele)) { // upper
																				// elment
			num += count(x - 1, y, ele);
		}
		if (withinBound(x + 1, y, ele) && rainFlowFrom(x, y, x + 1, y, ele)) { // lower
																				// element
			num += count(x + 1, y, ele);
		}
		if (withinBound(x, y - 1, ele) && rainFlowFrom(x, y, x, y - 1, ele)) { // left
																				// hand
																				// side
			num += count(x, y - 1, ele);
		}
		if (withinBound(x, y + 1, ele) && rainFlowFrom(x, y, x, y + 1, ele)) { // right
																				// hand
																				// side
			num += count(x, y + 1, ele);
		}

		// diagonal neighbors
		if (withinBound(x - 1, y - 1, ele)
				&& rainFlowFrom(x, y, x - 1, y - 1, ele)) { // upper elment
			num += count(x - 1, y - 1, ele);
		}
		if (withinBound(x + 1, y + 1, ele)
				&& rainFlowFrom(x, y, x + 1, y + 1, ele)) { // lower element
			num += count(x + 1, y + 1, ele);
		}
		if (withinBound(x + 1, y - 1, ele)
				&& rainFlowFrom(x, y, x + 1, y - 1, ele)) { // left hand side
			num += count(x + 1, y - 1, ele);
		}
		if (withinBound(x - 1, y + 1, ele)
				&& rainFlowFrom(x, y, x - 1, y + 1, ele)) { // right hand side
			num += count(x - 1, y + 1, ele);
		}

		return num;
	}

	static Boolean withinBound(int x, int y, int[][] ele) {
		int bound = ele.length;
		return (x >= 0 && x < bound && y >= 0 && y < bound);
	}

	static Boolean rainFlowFrom(int a, int b, int c, int d, int[][] ele) {
		// rain in (c,d) flows into (a,b).
		if (ele[a][b] >= ele[c][d])
			// if (a,b) is higher than (c,d), impossible to flow this way
			return false;

		int lowest = lowestNeighbor(c, d, ele);

		return (ele[a][b] == lowest);
		// the question states "you may assume it has a unique lowest neighbor"
		// so if flow to (a,b), then that is the unique lowest height.
	}

	static int lowestNeighbor(int a, int b, int[][] ele) {
		int height = 9999999;

		// adjacent neighbor
		if (withinBound(a - 1, b, ele) && ele[a - 1][b] < height) {
			height = ele[a - 1][b];
		}
		if (withinBound(a + 1, b, ele) && ele[a + 1][b] < height) {
			height = ele[a + 1][b];
		}
		if (withinBound(a, b - 1, ele) && ele[a][b - 1] < height) {
			height = ele[a][b - 1];
		}
		if (withinBound(a, b + 1, ele) && ele[a][b + 1] < height) {
			height = ele[a][b + 1];
		}

		// diagonal neighbor
		if (withinBound(a - 1, b - 1, ele) && ele[a - 1][b - 1] < height) {
			height = ele[a - 1][b - 1];
		}
		if (withinBound(a + 1, b - 1, ele) && ele[a + 1][b - 1] < height) {
			height = ele[a + 1][b - 1];
		}
		if (withinBound(a - 1, b + 1, ele) && ele[a - 1][b + 1] < height) {
			height = ele[a - 1][b + 1];
		}
		if (withinBound(a + 1, b + 1, ele) && ele[a + 1][b + 1] < height) {
			height = ele[a + 1][b + 1];
		}
		return height;
	}
}

class Pair {

	public int X;
	public int Y;

	public Pair(int _x, int _y) {
		X = _x;
		Y = _y;
	}
}
