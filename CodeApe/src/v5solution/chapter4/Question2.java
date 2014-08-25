package v5solution.chapter4;

import java.util.Iterator;
import java.util.Stack;

import common.DirectedGraph;

/**
 * Given a directed graph, design an algorithm to find out whether there is a
 * route between two nodes.
 * 
 */
// O(1) Space, O(V + E) time
public class Question2 {

	public boolean isRouteBetween(DirectedGraph g, int nodeIdx1, int nodeIdx2) {
		// write implementation here
		return reachable(g, nodeIdx1, nodeIdx2)
				|| reachable(g, nodeIdx2, nodeIdx1);
	}

	private boolean reachable(DirectedGraph g, int from, int to) {
		boolean[] visited = new boolean[g.V()];
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(from);

		while (!stack.isEmpty()) {
			int cur = stack.pop();
			visited[cur] = true;
			Iterator<Integer> neighbors = g.adj(cur).iterator();
			while (neighbors.hasNext()) {
				int neighbor = neighbors.next();
				if (!visited[neighbor]) {
					if (neighbor == to) {
						return true;
					}
					stack.push(neighbor);
				}
			}
		}

		return false;
	}

}
