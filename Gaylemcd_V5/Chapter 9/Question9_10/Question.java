package Question9_10;

import java.util.ArrayList;
import java.util.HashMap;

public class Question {

	public static int stackHeight(ArrayList<Box> boxes) {
		if (boxes == null) {
			return 0;
		}
		int h = 0;
		for (Box b : boxes) {
			h += b.height;
		}
		return h;
	}

	public static ArrayList<Box> createStackR(Box[] boxes, Box bottom) {
		int max_height = 0;
		ArrayList<Box> max_stack = null;
		for (int i = 0; i < boxes.length; i++) {
			if (boxes[i].canBeAbove(bottom)) {
				ArrayList<Box> new_stack = createStackR(boxes, boxes[i]);
				int new_height = stackHeight(new_stack);
				if (new_height > max_height) {
					max_stack = new_stack;
					max_height = new_height;
				}
			}
		}

		if (max_stack == null) {
			max_stack = new ArrayList<Box>();
		}
		if (bottom != null) {
			max_stack.add(0, bottom);
		}

		return max_stack;
	}

	public static ArrayList<Box> createStackDP(Box[] boxes, Box bottom,
			HashMap<Box, ArrayList<Box>> stack_map) {
		if (bottom != null && stack_map.containsKey(bottom)) {
			return (ArrayList<Box>) stack_map.get(bottom).clone();
		}

		int max_height = 0;
		ArrayList<Box> max_stack = null;
		for (int i = 0; i < boxes.length; i++) {
			if (boxes[i].canBeAbove(bottom)) {
				ArrayList<Box> new_stack = createStackDP(boxes, boxes[i],
						stack_map);
				int new_height = stackHeight(new_stack);
				if (new_height > max_height) {
					max_stack = new_stack;
					max_height = new_height;
				}
			}
		}

		if (max_stack == null) {
			max_stack = new ArrayList<Box>();
		}
		if (bottom != null) {
			max_stack.add(0, bottom);
		}
		stack_map.put(bottom, max_stack);

		return max_stack;
	}

	public static void main(String[] args) {

		Box[] boxes = { new Box(3, 3, 1), new Box(8, 6, 2), new Box(6, 4, 2),
				new Box(7, 8, 2), new Box(7, 5, 3) };

		test(boxes);

		boxes[3] = new Box(7, 10, 2);
		test(boxes);

		// now test speed
		testSpeedDP(boxes);
		testSpeedR(boxes);
		testSpeedMe(boxes);
	}

	private static final int ITERATIONS = 100000;

	private static void testSpeedDP(Box[] boxes) {
		long startTime = System.nanoTime();

		for (int i = 0; i < ITERATIONS; i++) {
			createStackDP(boxes, null, new HashMap<Box, ArrayList<Box>>());
		}

		long endTime = System.nanoTime();

		long duration = (endTime - startTime) / ITERATIONS;
		System.out.println("DP solution is        " + duration);
	}

	private static void testSpeedR(Box[] boxes) {
		long startTime = System.nanoTime();

		for (int i = 0; i < ITERATIONS; i++) {
			createStackR(boxes, null);
		}

		long endTime = System.nanoTime();

		long duration = (endTime - startTime) / ITERATIONS;
		System.out.println("Recursive solution is " + duration);
	}

	private static void testSpeedMe(Box[] boxes) {
		long startTime = System.nanoTime();

		for (int i = 0; i < ITERATIONS; i++) {
			MyAnswer.createStack(boxes);
		}

		long endTime = System.nanoTime();

		long duration = (endTime - startTime) / ITERATIONS;
		System.out.println("My solution is         " + duration);
	}

	private static void test(Box[] boxes) {

		ArrayList<Box> stack = createStackDP(boxes, null,
				new HashMap<Box, ArrayList<Box>>());
		System.out.println("DP:");
		for (int i = stack.size() - 1; i >= 0; i--) {
			Box b = stack.get(i);
			System.out.print(b.toString() + " on ");
		}
		System.out.println("finish.");

		stack = createStackR(boxes, null);
		System.out.println("Recursive:");
		for (int i = stack.size() - 1; i >= 0; i--) {
			Box b = stack.get(i);
			System.out.print(b.toString() + " on ");
		}
		System.out.println("finish.");

		stack = MyAnswer.createStack(boxes);
		System.out.println("My answer:");
		for (int i = stack.size() - 1; i >= 0; i--) {
			Box b = stack.get(i);
			System.out.print(b.toString() + " on ");
		}
		System.out.println("finish.");
		System.out.println();
	}

}
