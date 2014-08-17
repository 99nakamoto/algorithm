package algo.needUnitTest;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

// This is the code for Topology Sorting of a Graph

// this source code comes from 
// http://codereview.stackexchange.com/questions/44689/topological-sort-in-java

public class TopologySorting {
	private int vertices;
	private Set<Node> nodes = new HashSet<Node>();

	public TopologySorting(int vertices) {
		this.vertices = vertices;
	}

	public void addVertex(Node node) {
		this.nodes.add(node);
	}

	public Set<Node> topologicalSort() {
		Queue<Node> q = new LinkedList<Node>();
		Set<Node> topoSort = new LinkedHashSet<Node>();
		int vertexProcessesCtr = 0;
		for (Node m : this.nodes) {
			vertexProcessesCtr = addToQueue(m, topoSort, vertexProcessesCtr, q);
		}
		while (!q.isEmpty()) {
			Node m = q.poll();
			for (Node child : m.AdjacenctNode) {
				int indeq = child.inDegree - 1;
				child.inDegree = indeq;
				vertexProcessesCtr = addToQueue(child, topoSort,
						vertexProcessesCtr, q);
			}
		}
		if (vertexProcessesCtr > this.vertices) {
			System.out.println();
		}
		return topoSort;
	}

	private int addToQueue(Node node, Set<Node> topoSort, int vertexProcess,
			Queue<Node> q) {
		if (node.inDegree == 0) {
			q.add(node);
			topoSort.add(node);
			return vertexProcess + 1;
		}
		return vertexProcess;
	}

	public static void main(String[] args) {
		TopologySorting g = new TopologySorting(8);

		Node TEN = new Node("10");
		Node ELEVEN = new Node("11");
		Node TWO = new Node("2");
		Node THREE = new Node("3");
		Node FIVE = new Node("5");
		Node SEVEN = new Node("7");
		Node EIGHT = new Node("8");
		Node NINE = new Node("9");

		SEVEN.AdjacenctNode.add(ELEVEN);
		ELEVEN.inDegree++;
		SEVEN.AdjacenctNode.add(EIGHT);
		EIGHT.inDegree++;
		FIVE.AdjacenctNode.add(ELEVEN);
		ELEVEN.inDegree++;
		THREE.AdjacenctNode.add(EIGHT);
		EIGHT.inDegree++;
		THREE.AdjacenctNode.add(TEN);
		TEN.inDegree++;
		ELEVEN.AdjacenctNode.add(TEN);
		TEN.inDegree++;
		ELEVEN.AdjacenctNode.add(TWO);
		TWO.inDegree++;
		ELEVEN.AdjacenctNode.add(NINE);
		NINE.inDegree++;
		EIGHT.AdjacenctNode.add(NINE);
		NINE.inDegree++;

		g.nodes.add(TWO);
		g.nodes.add(THREE);
		g.nodes.add(FIVE);
		g.nodes.add(SEVEN);
		g.nodes.add(EIGHT);
		g.nodes.add(NINE);

		System.out.println("Now calling the topologial sorts");
		Set<Node> result = g.topologicalSort();
		for (Node node : result) {
			System.out.println(node.data + " ");
		}
	}
}

class Node {
	public String data;
	public int dist;
	public int inDegree;
	LinkedList<Node> AdjacenctNode = new LinkedList<Node>();

	public void addAdjNode(final Node Child) {
		AdjacenctNode.add(Child);
		Child.inDegree++;
	}

	public Node(String data) {
		super();
		this.data = data;
	}
}
