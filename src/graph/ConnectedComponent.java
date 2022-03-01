package graph;

import java.util.ArrayList;

public class ConnectedComponent {
	int V;
	ArrayList<Integer> adjListArray[];
	int count = 0 ;

	// constructor
	ConnectedComponent(int V) {
		this.V = V;
		adjListArray = new ArrayList[V];

		for (int i = 0; i < V; i++) {
			adjListArray[i] = new ArrayList<>();
		}
	}

	void addEdge(int src, int dest) {
		adjListArray[src].add(dest);

		adjListArray[dest].add(src);
	}

	void DFSUtil(int v, boolean[] visited) {
		visited[v] = true;
		System.out.print(v + " ");

			for (int x : adjListArray[v]) {
				if (!visited[x])
					DFSUtil(x, visited);
			}
	
	}

	void connectedComponents() {
		// Mark all the vertices as not visited
		boolean[] visited = new boolean[V];
		for (int v = 0; v < V; ++v) {
			if (!visited[v]) {
				DFSUtil(v, visited);
				count++;
				System.out.println();
			}
		}
		System.out.println("count: "+ count);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Create a graph given in the above diagram
		ConnectedComponent g = new ConnectedComponent(5); // 5 vertices numbered from 0 to 4

		g.addEdge(1, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 4);
		System.out.println("Following are connected components");
		g.connectedComponents();

		
	}

}
