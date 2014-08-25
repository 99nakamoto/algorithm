package algo.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class JobScheduler {
	/*
	 * deps[id]
	 */
	public boolean jobSchedule(Map<Integer, List<Integer>> deps, int n,
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
		Stack<Integer> sta = new Stack<Integer>();
		for (int i = 1; i <= n; i++)
			if (indeg[i] == 0)
				sta.push(i);
		for (int t = 0; t < n; t++) {
			if (sta.empty())
				return false;
			int id = sta.pop();
			result[t] = id;
			if (rmap.containsKey(id)) {
				for (int id2 : rmap.get(id)) {
					indeg[id2]--;
					if (indeg[id2] == 0)
						sta.push(id2);
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		JobScheduler ins = new JobScheduler();
		Map<Integer, List<Integer>> deps = new HashMap<Integer, List<Integer>>();
		deps.put(1, new ArrayList<Integer>());
		deps.put(3, new ArrayList<Integer>());
		deps.get(1).add(2);
		deps.get(1).add(3);
		deps.get(3).add(4);
		int[] result = new int[5];
		ins.jobSchedule(deps, 5, result);
		System.out.println(Arrays.toString(result));
	}
}
