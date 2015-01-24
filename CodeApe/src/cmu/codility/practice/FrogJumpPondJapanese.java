package cmu.codility.practice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @time Jan 21, 2014 morning
 * @url http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=2223
 */

public class FrogJumpPondJapanese {

	public void run(String input, String output) throws Exception {
		BufferedReader in = new BufferedReader(new FileReader(new File(
				FrogJumpPondJapanese.class.getResource(input).toURI())));
		PrintWriter out = new PrintWriter(new FileWriter(output));

		// start reading input data
		String line = in.readLine();

		// 1. read number parts
		String[] nums = line.split(" ");
		int rows = Integer.parseInt(nums[0]);
		int cols = Integer.parseInt(nums[1]);
		char[][] map = new char[rows][cols];

		// 2. read the pond map, and count the leaf
		int leafCount = 0;
		Position initPos = null;
		for (int i = 0; i < rows; i++) {
			line = in.readLine();
			map[i] = line.toCharArray();
			for (int j = 0; j < cols; j++) {
				if (map[i][j] == 'o') {
					// this is a leaf
					leafCount++;
				} else if (map[i][j] != '.') {
					// this is a frog standing position
					initPos = new Position(i, j, null);
					switch (map[i][j]) {
					case 'U':
						initPos.direction = new Direction(-1, 0);
						break;
					case 'D':
						initPos.direction = new Direction(1, 0);
						break;
					case 'L':
						initPos.direction = new Direction(0, -1);
						break;
					case 'R':
						initPos.direction = new Direction(0, 1);
						break;
					}
					// set map[i][j] = '.' because we do assume the leaf that
					// the frog is standing on doesn't exist - it's going to
					// sink into pond no matter what
					map[i][j] = '.';
				}
			}
		}
		for (char[] cl : map) {
			for (char c : cl) {
				System.out.print(c);
			}
			System.out.println();
		}

		// run the logic
		solve("", map, initPos, leafCount);

		// testing
		out.write("Testing: leaf count " + leafCount);

		// destruct reader and writer
		in.close();
		out.close();
	}

	private boolean solve(String path, char[][] map, Position curPos,
			int leafCount) {
		if (leafCount == 0) {
			System.out.println(path);
			return true;
		}
		int rows = map.length;
		int cols = map[0].length;

		// now do dfs, there are 3 directions to jump
		List<Direction> fourDirections = new ArrayList<Direction>();
		fourDirections.add(new Direction(-1, 0)); // up
		fourDirections.add(new Direction(0, 1)); // right
		fourDirections.add(new Direction(1, 0)); // down
		fourDirections.add(new Direction(0, -1)); // left
		for (Direction jumpDirection : fourDirections) {
			if (jumpDirection.isOpposite(curPos.direction)) {
				// a frog could not jump backwards
				continue;
			}
			// jumpDirection is ensured to be valid
			// start to jump the frog until the first occurence of leaf, or
			// until out of bound
			Position targetPos = curPos.jump(jumpDirection, rows, cols);
			// initial jump of the frog
			while (targetPos != null) {
				if (map[targetPos.x][targetPos.y] == 'o') {
					// found a leaf, frog is able to jump to this position
					map[targetPos.x][targetPos.y] = '.';
					if (solve(path + jumpDirection.toString(), map, targetPos,
							leafCount - 1)) {
						return true;
					}
					map[targetPos.x][targetPos.y] = 'o';
					// if jumping to targetPos leads to correct result,
					// return true. otherwise, go on and test out all 3
					// directions of jump before returning false
					break;
				} else {
					targetPos = targetPos.jump(jumpDirection, rows, cols);
				}
			}
			// frog is unable to jump to any valid leaf in this
			// jumpDirection
		}
		return false;
	}

	class Position {
		int x;
		int y;
		Direction direction;

		public Position(int x, int y, Direction d) {
			this.x = x;
			this.y = y;
			direction = d;
		}

		public Position jump(Direction jumpDirection, int xBound, int yBound) {
			int newX = this.x + jumpDirection.xAxis;
			int newY = this.y + jumpDirection.yAxis;
			if (newX < 0 || newX >= xBound || newY < 0 || newY >= yBound) {
				return null;
			} else {
				// note that after jumping addition, jump direction retains
				return new Position(newX, newY, jumpDirection);
			}
		}
	}

	class Direction {
		int xAxis;
		int yAxis;

		public Direction(int x, int y) {
			xAxis = x;
			yAxis = y;
		}

		public boolean isOpposite(Direction d) {
			if (this.xAxis + d.xAxis == 0 && this.yAxis + d.yAxis == 0) {
				return true;
			}
			return false;
		}

		public String toString() {
			if (xAxis == 0) {
				if (yAxis == 1) {
					return "R";
				} else { // -1
					return "L";
				}
			} else if (xAxis == 1) {
				return "D";
			} else {
				return "U";
			}
		}
	}

	public static void main(String[] args) throws Exception {
		FrogJumpPondJapanese main = new FrogJumpPondJapanese();

		String input = "frog_test.in";
		String output = "frog_test.out";
		long startTime = System.currentTimeMillis();

		main.run(input, output);

		System.out.println("Total time = "
				+ (System.currentTimeMillis() - startTime));
		System.exit(0);
	}
}