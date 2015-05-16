package algo.questions;

import java.util.ArrayList;
import java.util.List;

/*
 * LinkedIn question
 * 
 * Given a nested list of integers, returns the sum of all integers in the
 * list weighted by their depth For example, given the list {{1,1},2,{1,1}}
 * the function should return 10 (four 1's at depth 2, one 2 at depth 1)
 * Given the list {1,{4,{6}}} the function should return 27 (one 1 at depth
 * 1, one 4 at depth 2, and one 6 at depth 3)
 */

/*
 * This is the interface that represents nested lists. You should not implement
 * it, or speculate about its implementation.
 */
interface NestedInteger {
	/**
	 * @return true if this NestedInteger holds a single integer, rather than a
	 *         nested list
	 */
	boolean isInteger();

	/**
	 * @return the single integer that this NestedInteger holds, if it holds a
	 *         single integer Return null if this NestedInteger holds a nested
	 *         list
	 */
	Integer getInteger();

	/**
	 * @return the nested list that this NestedInteger holds, if it holds a
	 *         nested list Return null if this NestedInteger holds a single
	 *         integer
	 */
	List<NestedInteger> getList();
}

class NestedIntegerImpl implements NestedInteger {

	int num;
	List<NestedInteger> list = new ArrayList<NestedInteger>();

	public NestedIntegerImpl(int number) {
		num = number;
		list = null;
	}

	public NestedIntegerImpl(List<NestedInteger> inputList) {
		num = -1;
		list = inputList;
	}

	@Override
	public boolean isInteger() {
		return list == null;
	}

	@Override
	public Integer getInteger() {
		if (isInteger()) {
			return num;
		}
		return -1;
	}

	@Override
	public List<NestedInteger> getList() {
		return list;
	}
}

public class SumIntegerWeightedByDepth {

	public static void main(String[] args) {
		SumIntegerWeightedByDepth ins = new SumIntegerWeightedByDepth();
		long startTime = System.currentTimeMillis();

		System.out.println("Start Run... ");

		// build this: {1, {4, {6}}}
		NestedInteger level1 = new NestedIntegerImpl(
				new ArrayList<NestedInteger>());
		NestedInteger level2 = new NestedIntegerImpl(
				new ArrayList<NestedInteger>());
		NestedInteger level3 = new NestedIntegerImpl(
				new ArrayList<NestedInteger>());

		level1.getList().add(new NestedIntegerImpl(1));
		level1.getList().add(level2);
		level2.getList().add(new NestedIntegerImpl(4));
		level2.getList().add(level3);
		level3.getList().add(new NestedIntegerImpl(6));

		System.out.println("Sum = " + ins.depthSum(level1.getList(), 1));
		System.out.println();

		System.out.print("Total time = ");
		System.out.print((System.currentTimeMillis() - startTime) / 1000.0);
	}

	public int depthSum(List<NestedInteger> input, int weight) {
		// ur implementation here
		int sum = 0;
		for (NestedInteger ni : input) {
			if (ni.isInteger()) {
				sum += ni.getInteger() * weight;
			} else {
				sum += depthSum(ni.getList(), weight + 1);
			}
		}
		return sum;
	}
}
