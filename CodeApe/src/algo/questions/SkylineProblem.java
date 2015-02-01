package algo.questions;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import common.Common;

public class SkylineProblem {

	public static void main(String[] args) {
		SkylineProblem ins = new SkylineProblem();

		List<Building> list = new ArrayList<Building>();
		list.add(new Building(2, 4, 5));
		list.add(new Building(3, 5, 11));
		list.add(new Building(4, 7, 17));
		list.add(new Building(6, 10, 9));
		list.add(new Building(8, 9, 13));

		// answer should be {0, 0, 5, 11, 17, 17, 17, 9, 13, 9, 0, 0}

		int[] heights = ins.skyline(list, 0, 12);
		System.out.println("Ans: ");
		Common.printArray(heights);
	}

	public int[] skyline(List<Building> bds, int min, int max) {
		int[] output = new int[max - min];

		List<Edge>[] edges = new List[max - min];
		for (int i = 0; i < edges.length; i++) {
			edges[i] = new ArrayList<Edge>();
		}
		for (Building b : bds) {
			// put all edges into an array of edges
			edges[b.from].add(new Edge(b, true));
			edges[b.to].add(new Edge(b, false));
		}

		Queue<Building> heap = new PriorityQueue<Building>(100,
				new Comparator<Building>() {
					public int compare(Building b1, Building b2) {
						return b2.height - b1.height;
					}
				});
		for (int i = 0; i < edges.length; i++) {
			// insert or remove each building at position i into max heap
			for (Edge e : edges[i]) {
				if (e.isEnter) {
					heap.add(e.building);
				} else {
					heap.remove(e.building);
				}
			}
			// then culculate the current hight, which is top of the heap
			if (!heap.isEmpty()) {
				output[i] = heap.peek().height;
			}
		}

		return output;
	}

	static class Edge {
		Building building;
		boolean isEnter;

		public Edge(Building bld, boolean enter) {
			building = bld;
			isEnter = enter;
		}
	}

	static class Building {
		int from;
		int to;
		int height;

		public Building(int a, int b, int c) {
			from = a;
			to = b;
			height = c;
		}
	}
}
