package cc150.common;

import java.util.LinkedList;

public class DirectedGraph {

	private int v;
	private LinkedList<Integer> edges[];

	@SuppressWarnings("unchecked")
	public DirectedGraph(int nodeSize) {
		this.v = nodeSize;
		this.edges = (LinkedList<Integer>[]) new LinkedList<?>[v];
		for (int i = 0; i < v; ++i) {
			this.edges[i] = new LinkedList<Integer>();
		}
	}

	public void addEdge(int v, int w) {
		this.edges[v].add(w);
	}

	public Iterable<Integer> adj(int v) {
		return edges[v];
	}

	public int V() {
		return v;
	}

	public int E() {
		int e = 0;
		for (LinkedList<Integer> edge : edges)
			e += edge.size();
		return e;
	}

}