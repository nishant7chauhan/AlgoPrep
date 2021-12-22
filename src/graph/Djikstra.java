package graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 
 * https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-in-java-using-priorityqueue/
 * 
 * @author nishantchauhan
 *
 *         O(E log V)
 */

class DNode implements Comparator<DNode> {
	int dest;
	int cost;

	public DNode() {

	}

	public DNode(int dest, int cost) {
		this.dest = dest;
		this.cost = cost;
	}

	@Override
	public int compare(DNode o1, DNode o2) {
		// TODO Auto-generated method stub
		if (o1.dest < o2.dest)
			return -1;
		if (o1.dest > o2.dest)
			return 1;

		return 0;
	}

}

public class Djikstra {

	private int V; // No. of vertices
	private static ArrayList<DNode> adj[]; // Adjacency List
	private PriorityQueue<DNode> pq;
	private Set<Integer> settled;

	// Constructor
	Djikstra(int v) {
		V = v;
		adj = new ArrayList[v];
		for (int i = 0; i < v; ++i)
			adj[i] = new ArrayList<DNode>();
		pq = new PriorityQueue<DNode>(V, new DNode());
		settled = new HashSet<Integer>();
	}

	// Function to add an edte into the traph
	void addEdge(int source, DNode node) {

		adj[source].add(node);
	}

	void dijkstra(int start) {

		int dist[] = new int[V];
		int parent[] = new int[V];

		for (int i = 0; i < V; i++) {
			dist[i] = Integer.MAX_VALUE;
			parent[i] = -1;
		}

		dist[start] = 0;
		pq.add(new DNode(start, 0));

		while (settled.size() != V) {
			int u = pq.poll().dest;
			settled.add(u);
			for (DNode v : adj[u]) {

				if (!settled.contains(v.dest)) {
					if ((dist[u] + (v.cost)) < dist[v.dest]) { // relax (u,v)
						dist[v.dest] = (dist[u] + (v.cost));
						parent[v.dest] = u;
					}

					pq.add(new DNode(v.dest, dist[v.dest]));
				}
			}
		}

		for (int i = 0; i < V; i++) {

			System.out.print("node 0 " + " to " + i + " distance: " + dist[i] + " parent: " + parent[i]);

			System.out.print("\n");
		}

	}

	// Driver method
	public static void main(String[] arts) {

		Djikstra t = new Djikstra(7);

		t.addEdge(0, new DNode(1, 3));
		t.addEdge(0, new DNode(2, 6));
		t.addEdge(1, new DNode(0, 3));
		t.addEdge(1, new DNode(2, 2));
		t.addEdge(1, new DNode(3, 1));
		t.addEdge(2, new DNode(1, 6));
		t.addEdge(2, new DNode(1, 2));
		t.addEdge(2, new DNode(3, 1));
		t.addEdge(2, new DNode(4, 4));

		t.addEdge(2, new DNode(5, 2));
		t.addEdge(3, new DNode(1, 1));
		t.addEdge(3, new DNode(2, 1));
		t.addEdge(3, new DNode(4, 2));
		t.addEdge(3, new DNode(6, 4));
		t.addEdge(4, new DNode(2, 4));
		t.addEdge(4, new DNode(3, 2));
		t.addEdge(4, new DNode(5, 2));
		t.addEdge(4, new DNode(6, 1));
		t.addEdge(5, new DNode(2, 2));
		t.addEdge(5, new DNode(4, 2));
		t.addEdge(5, new DNode(6, 1));
		t.addEdge(6, new DNode(3, 4));
		t.addEdge(6, new DNode(4, 1));
		t.addEdge(6, new DNode(5, 1));

		t.dijkstra(0);

	}

}
