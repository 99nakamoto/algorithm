package Question4_2;

import java.util.LinkedList;
import java.util.Queue;

public class MyAnswer {

	public static boolean search(Graph g, Node start, Node end) {
		if (start == null || end == null) {
			return false;
		} else if (start == end) {
			return true;
		}
		// bfs search
		Queue<Node> q = new LinkedList<Node>();
		q.offer(start);
		while (!q.isEmpty()) {
			Node cur = q.poll();
			if (cur == end) {
				System.out.println("something is really wrong. ");
			}
			cur.state = State.Visiting;
			for (Node nei : cur.getAdjacent()) {
				if (nei.state == State.Visited) {
					continue;
				} else {
					if (nei == end) {
						return true;
					} else {
						q.offer(nei);
					}
				}
			}
			cur.state = State.Visited;
		}
		return false;
	}

	public static void main(String a[]) {
		Graph g = createNewGraph();
		Node[] n = g.getNodes();

		Node start = n[3];
		Node end = n[5];
		System.out.println(search(g, start, end) + " should be true");

		start = n[3];
		end = n[6];
		System.out.println(search(g, start, end) + " should be false");
	}

	public static Graph createNewGraph() {
		Graph g = new Graph();
		Node[] temp = new Node[7];

		temp[0] = new Node("a", 3);
		temp[1] = new Node("b", 0);
		temp[2] = new Node("c", 0);
		temp[3] = new Node("d", 1);
		temp[4] = new Node("e", 1);
		temp[5] = new Node("f", 0);
		temp[6] = new Node("z", 10);

		temp[0].addAdjacent(temp[1]);
		temp[0].addAdjacent(temp[2]);
		temp[0].addAdjacent(temp[3]);
		temp[3].addAdjacent(temp[4]);
		temp[4].addAdjacent(temp[5]);
		for (int i = 0; i < 7; i++) {
			g.addNode(temp[i]);
		}
		return g;
	}
}
