import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

class UndirectedGraphNode {
	int label;
	List<UndirectedGraphNode> neighbors;

	UndirectedGraphNode(int x) {
		label = x;
		neighbors = new ArrayList<UndirectedGraphNode>();
	}
};

public class Solution {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null)
			return null;
		HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
		map.put(node, new UndirectedGraphNode(node.label));
		LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
		queue.offer(node);
		// queue is guaranteed to always have non-traversed nodes
		while (!queue.isEmpty()) {
			UndirectedGraphNode orin = queue.poll();
			UndirectedGraphNode cp = map.get(orin);
			for (UndirectedGraphNode n : orin.neighbors) {
				if (!map.containsKey(n)) {
					map.put(n, new UndirectedGraphNode(n.label));
					queue.offer(n);
				}
				UndirectedGraphNode newNode = map.get(n);
				cp.neighbors.add(newNode);
			}
		}
		return map.get(node);
	}

	public static void main(String[] args) {
		Solution ins = new Solution();
		UndirectedGraphNode input = new UndirectedGraphNode(0);
		input.neighbors.add(input);
		input.neighbors.add(input);
		UndirectedGraphNode output = ins.cloneGraph(input);
		System.out.println(output.label);
		System.out.println(output.neighbors.size());
	}
}
