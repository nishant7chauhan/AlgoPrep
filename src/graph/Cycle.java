package graph;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 1.detect cycle in directed graph
 * 2.Find whether it is possible to finish all tasks or not from given dependencies.
 * https://www.youtube.com/watch?v=0dJmTuMrUZM
 * 
 * @author nishantchauhan
 * 
 * O(V+E)
 *
 */



public class Cycle {

	private int V; // No. of vertices
	private ArrayList<Integer> adj[]; // Adjacency List

	// Constructor
	Cycle(int v) {
		V = v;
		adj = new ArrayList[v];
		for (int i = 0; i < v; ++i)
			adj[i] = new ArrayList();
	}

	// Function to add an edge into the graph
	void addEdge(int v, int w) {
		adj[v].add(w);
	}

	private boolean detectCycleUtil(int v, int[] visited) { // graph coloring method
		// TODO Auto-generated method stub

		if (visited[v] == 1)
			return true;
		if (visited[v] == 2)
			return false;

		visited[v] = 1;

		Iterator<Integer> it = adj[v].iterator();
		while (it.hasNext()) {
			if (detectCycleUtil(it.next(), visited))
				return true;
		}

		visited[v] = 2;
		return false;
	}

	private boolean detectCycle() {
		// TODO Auto-generated method stub
		int visited[] = new int[V];

		for (int i = 0; i < V; i++)
			if (visited[i] == 0)
				if (detectCycleUtil(i, visited))
					return true;
		return false;

	}

	// Driver method
	public static void main(String args[]) {
		// Create a graph given in the above diagram
		Cycle g = new Cycle(7);
		/*
		 * g.addEdge(0, 1); g.addEdge(0, 2); g.addEdge(0, 3); g.addEdge(1, 2);
		 * g.addEdge(3, 4); g.addEdge(4, 5); g.addEdge(5, 3);
		 */
		/*
		 * g.addEdge(1,0); g.addEdge(0, 1);
		 * 
		 * [[1, 0], [2, 1], [3, 2]]
		 */
		g.addEdge(1, 0);
		g.addEdge(2, 1);
		g.addEdge(3, 2);
		
		System.out.print("Cycle in graph: " + g.detectCycle());
	}

}
