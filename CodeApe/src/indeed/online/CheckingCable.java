package indeed.online;
import java.util.*;

public class CheckingCable {

	private static Node[] nodes;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int Q = sc.nextInt();
		// N nodes, and Q instrcutions.

		nodes = new Node[N + 1];
		nodes[0] = null; // no use
		for (int i = 1; i <= N; i++) {
			nodes[i] = new Node(i);
		}

		for (int i = 0; i < Q; i++) {
			String instruction = sc.next();
			int a = sc.nextInt();
			int b = sc.nextInt();
			int t = sc.nextInt();

			if (instruction.equals("make")) {
				make(a, b, t);
			} else if (instruction.equals("check")) {
				if (check(a, b, t)) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
			}
		}
	}

	private static void make(int A, int B, int time) {
		// A < B
		if (A > B) {
			make(B, A, time);
			return;
		} else if (A == B) {
			return;
		}

		// connect A and B if not already connected
		// otherwise, just increase the weight
		// List<Edge> aEdges = ;
		boolean found = false;
		for (Edge e : nodes[A].edges) {
			// for each node A's edge, check value B
			if (e.n2.value == B || e.n1.value == B) {
				// found the edge
				found = true;
				e.weight = Math.max(e.weight, time);
				break;
			}
		}
		if (!found) {
			nodes[A].edges.add(new Edge(nodes[A], nodes[B], time));
			nodes[B].edges.add(new Edge(nodes[A], nodes[B], time));
		}
	}

	private static boolean check(int A, int B, int time) {
		// A < B
		if (A > B) {
			return check(B, A, time);
		} else if (A == B) {
			return true;
		}

		// BFS check
		Queue<Node> queue = new LinkedList<Node>();
		Queue<Node> visited = new LinkedList<Node>();
		queue.offer(nodes[A]);
		while (!queue.isEmpty()) {
			Node top = queue.poll();
			visited.offer(top);
			for (Edge e : top.edges) {
				if (e.weight < time) {
					continue;
				}
				// get the node on the other end of the edge
				Node other = getOtherEnd(e, top);
				if (visited.contains(other)) {
					continue;
				}
				if (other == nodes[B]) {
					return true;
				}
				queue.offer(other);
			}
		}
		return false;
	}

	private static Node getOtherEnd(Edge edge, Node node) {
		if (edge.n1 == node) {
			return edge.n2;
		}
		return edge.n1;
	}

	static class Node {
		int value;
		List<Edge> edges;

		public Node(int v) {
			this.value = v;
			this.edges = new ArrayList<Edge>();
		}
	}

	static class Edge {
		// bi-directional edge, 2 nodes are stored
		// n1.value < n2.value
		Node n1;
		Node n2;
		int weight;

		public Edge(Node n1, Node n2, int w) {
			this.n1 = n1;
			this.n2 = n2;
			this.weight = w;
		}
	}
}
