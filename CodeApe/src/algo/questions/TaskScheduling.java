package algo.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class TaskScheduling {

	public int[] myJobSchedulerWithoutQueue(Map<Integer, List<Integer>> deps,
			int n) {
		int[] ans = new int[n];

		int[] depCount = new int[n];
		// eg. job 1 depends on job 2 and 3, thus depCount[1-1] = 2
		Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
		// graph would be reversed version of deps, used for topology sorting
		// eg. 2 would point to 1, and 3 would points to 1
		for (int i : deps.keySet()) {
			depCount[i - 1] = deps.get(i).size();
			for (int j : deps.get(i)) {
				// add (j, i) pair into graph
				if (!graph.containsKey(j)) {
					graph.put(j, new ArrayList<Integer>());
				}
				graph.get(j).add(i);
			}
		}
		// now we got depCount[] and graph ready, let's rock
		int sorted = 0;
		while (sorted != n) {
			// first find a 'p' so that depCount[p] = 0
			int p = 0;
			while (p < n && depCount[p] != 0) {
				p++;
			}
			if (p == n) {
				// unable to find a new node to sort, sorting failed
				break;
			}
			// remember p is only the index, the value should be +1
			int val = p + 1;
			ans[sorted++] = val;
			depCount[p] = -1;
			if (graph.containsKey(val)) {
				for (int i : graph.get(val)) {
					depCount[i - 1]--;
				}
			}
		}
		if (sorted == n)
			return ans; // sort sucess
		else
			return null; // sort failed
	}

	public int[] myJobSchedulerWithQueue(Map<Integer, List<Integer>> deps, int n) {
		int[] ans = new int[n];

		int[] depCount = new int[n];
		// eg. job 1 depends on job 2 and 3, thus depCount[1-1] = 2
		Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
		// graph would be reversed version of deps, used for topology sorting
		// eg. 2 would point to 1, and 3 would points to 1
		for (int i : deps.keySet()) {
			depCount[i - 1] = deps.get(i).size();
			for (int j : deps.get(i)) {
				// add (j, i) pair into graph
				if (!graph.containsKey(j)) {
					graph.put(j, new ArrayList<Integer>());
				}
				graph.get(j).add(i);
			}
		}
		// now we got depCount[] and graph ready, let's rock
		int sorted = 0;
		Queue<Integer> queue = new LinkedList<Integer>();
		while (sorted != n) {
			for (int i = 0; i < depCount.length; i++) {
				if (depCount[i] == 0) {
					queue.offer(i + 1);
					depCount[i] = -1;
				}
			}
			if (queue.isEmpty()) {
				break; // sorting failed
			}
			int val = queue.poll();
			ans[sorted++] = val;
			if (graph.containsKey(val)) {
				for (int i : graph.get(val)) {
					depCount[i - 1]--;
				}
			}
		}
		if (sorted == n)
			return ans; // sort sucess
		else
			return null; // sort failed
	}

	/*
	 * deps[id]
	 */
	public boolean jobScheduleAnswer(Map<Integer, List<Integer>> deps, int n,
			int[] result) {
		int[] indeg = new int[n + 1];
		Map<Integer, List<Integer>> rmap = new HashMap<Integer, List<Integer>>();
		for (Map.Entry<Integer, List<Integer>> entry : deps.entrySet()) {
			int id1 = entry.getKey();
			for (int id2 : entry.getValue()) {
				if (!rmap.containsKey(id2))
					rmap.put(id2, new ArrayList<Integer>());
				rmap.get(id2).add(id1);
				indeg[id1]++;
			}
		}
		Queue<Integer> Q = new LinkedList<Integer>();
		for (int i = 1; i <= n; i++)
			if (indeg[i] == 0)
				Q.offer(i);
		for (int t = 0; t < n; t++) {
			if (Q.isEmpty())
				return false;
			int id = Q.poll();
			result[t] = id;
			if (rmap.containsKey(id)) {
				for (int id2 : rmap.get(id)) {
					indeg[id2]--;
					if (indeg[id2] == 0)
						Q.offer(id2);
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		TaskScheduling ins = new TaskScheduling();
		Map<Integer, List<Integer>> deps = new HashMap<Integer, List<Integer>>();
		// n=5
		// 1->2,3
		// 3->4
		deps.put(1, new ArrayList<Integer>());
		deps.put(3, new ArrayList<Integer>());
		deps.get(1).add(2);
		deps.get(1).add(3);
		deps.get(3).add(4);

		int[] result = new int[5];
		System.out.println("Soneone's answer: ");
		ins.jobScheduleAnswer(deps, 5, result);
		System.out.println(Arrays.toString(result));

		System.out.println("My answer without queue: ");
		int[] myAns = ins.myJobSchedulerWithoutQueue(deps, 5);
		System.out.println(Arrays.toString(myAns));

		System.out.println("My answer with a queue: ");
		myAns = ins.myJobSchedulerWithQueue(deps, 5);
		System.out.println(Arrays.toString(myAns));
	}
}
