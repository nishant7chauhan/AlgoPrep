package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class NetworkDelayTime {
	class Pair {
		int time, dest;

		Pair(int time, int dest) {
			this.time = time;
			this.dest = dest;
		}
	}
	// Adjacency list
	Map<Integer, List<Pair>> adj = new HashMap<>();

	private void dijkstra(int[] signalReceivedAt, int source, int n) {
		
		Queue<Pair> pq = new PriorityQueue<Pair>(new Comparator<Pair>() {
			@Override
			public int compare(Pair o1, Pair o2) {
				// TODO Auto-generated method stub
				return o1.time - o2.time;
			}
		});

		pq.add(new Pair(0, source));

		// Time for starting node is 0
		signalReceivedAt[source] = 0;

		while (!pq.isEmpty()) {
			Pair topPair = pq.remove();

			int currNode = topPair.dest;
			int currNodeTime = topPair.time;

			if (currNodeTime > signalReceivedAt[currNode]) {
				continue;
			}

			if (!adj.containsKey(currNode)) {
				continue;
			}

			// Broadcast the signal to adjacent nodes
			for (Pair edge : adj.get(currNode)) {
				int time = edge.time;
				int neighborNode = edge.dest;

				// Fastest signal time for neighborNode so far
				// signalReceivedAt[currNode] + time :
				// time when signal reaches neighborNode
				if (signalReceivedAt[neighborNode] > currNodeTime + time) {
					signalReceivedAt[neighborNode] = currNodeTime + time;
					pq.add(new Pair(signalReceivedAt[neighborNode], neighborNode));
				}
			}
		}
	}

	public int networkDelayTime(int[][] times, int n, int k) {
		// Build the adjacency list
		for (int[] time : times) {
			int source = time[0];
			int dest = time[1];
			int travelTime = time[2];

			adj.putIfAbsent(source, new ArrayList<>());
			adj.get(source).add(new Pair(travelTime, dest));
		}

		int[] signalReceivedAt = new int[n + 1];
		Arrays.fill(signalReceivedAt, Integer.MAX_VALUE);

		dijkstra(signalReceivedAt, k, n);

		int answer = Integer.MIN_VALUE;
		for (int i = 1; i <= n; i++) {
			answer = Math.max(answer, signalReceivedAt[i]);
		}

		// INT_MAX signifies atleat one node is unreachable
		return answer == Integer.MAX_VALUE ? -1 : answer;
	}

	public static void main(String[] args) {

		NetworkDelayTime obj = new NetworkDelayTime();

		int[][] times = { { 2, 1, 1 }, { 2, 3, 1 }, { 3, 4, 1 } };
		int n = 4;
		int k = 2;

		System.out.print(obj.networkDelayTime(times, n, k));
	}

}
