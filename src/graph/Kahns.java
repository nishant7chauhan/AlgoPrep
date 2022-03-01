package graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * kahn's algo for topological sort, can detect cycle also
 * 
 * useful when need to schedule task in parallel as we check based on indegree 0
 * 
 * https://www.youtube.com/watch?v=tggiFvaxjrY
 * 
 * @author nishantchauhan
 *
 */

public class Kahns {

	// No. of vertices
	int V;

	// An Array of List which contains
	// references to the Adjacency List of
	// each vertex
	ArrayList<Integer> adj[];

	// Constructor
	public Kahns(int V) {
		this.V = V;
		adj = new ArrayList[V];
		for (int i = 0; i < V; i++)
			adj[i] = new ArrayList<Integer>();
	}

	// Function to add an edge to graph
	public void addEdge(int u, int v) {
		adj[u].add(v);
	}

	// prints a Topological Sort of the
	// complete graph
	public void topologicalSort() {
		// Create a array to store
		// indegrees of all
		// vertices. Initialize all
		// indegrees as 0.
		int indegree[] = new int[V];

		// Traverse adjacency lists
		// to fill indegrees of
		// vertices. This step takes
		// O(V+E) time
		for (int i = 0; i < V; i++) {
			for (int node : adj[i]) {
				indegree[node]++;
			}
		}

		// Create a queue and enqueue
		// all vertices with indegree 0
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 0; i < V; i++) {
			if (indegree[i] == 0)
				q.add(i);
		}

		// Initialize count of visited vertices
		int cnt = 0;

		// Create a vector to store result
		// (A topological ordering of the vertices)
		List<Integer> topOrder = new ArrayList<Integer>();
		while (!q.isEmpty()) {
			// Extract front of queue
			// (or perform dequeue)
			// and add it to topological order
			int u = q.poll();
			topOrder.add(u);

			// Iterate through all its
			// neighbouring nodes
			// of dequeued node u and
			// decrease their in-degree
			// by 1
			for (int node : adj[u]) {
				// If in-degree becomes zero,
				// add it to queue
				if (--indegree[node] == 0)
					q.add(node);
			}
			cnt++;
		}

		// Check if there was a cycle
		if (cnt != V) {
			System.out.println("There exists a cycle in the graph");
			return;
		}

		// Print topological order
		for (int i : topOrder) {
			System.out.print(i + " ");
		}
	}

	// Example usage:
	public static void main(String[] args) {
		exampleFromSlides();
		// cycleTest();
	}

	private static void exampleFromSlides() {
		Kahns g = new Kahns(6);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(3, 1);
		g.addEdge(3, 2);
		g.addEdge(2, 4);
		g.addEdge(4, 5);

		g.topologicalSort();
		// int[] ordering = g.Kahns();

		// Prints: [0, 9, 13, 3, 2, 10, 1, 6, 7, 11, 4, 12, 5, 8]
		// System.out.println(java.util.Arrays.toString(ordering));

	}

	private static void cycleTest() {
		Kahns g = new Kahns(4);
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(2, 3);
		g.addEdge(3, 0);

		// System.out.println(java.util.Arrays.toString(g.kahns()));
		g.topologicalSort();
	}

}
