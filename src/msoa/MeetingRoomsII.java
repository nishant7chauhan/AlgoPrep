package msoa;

import java.util.Arrays;
import java.util.PriorityQueue;

class Pair {

	int start, end;

	Pair(int start, int end) {
		this.start = start;
		this.end = end;
	}
}

public class MeetingRoomsII {

	public static int minMeetingRooms(Pair[] intervals) {

		if (intervals == null || intervals.length == 0)
			return 0;

		Arrays.sort(intervals, (a, b) -> (a.start - b.start));
		PriorityQueue<Integer> heap = new PriorityQueue<>();

		heap.offer(intervals[0].end);
		for (int i = 1; i < intervals.length; i++) {

			if (heap.peek() <= intervals[i].start) {
				heap.poll();
			}
			heap.offer(intervals[i].end);

		}
		return heap.size();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Pair[] intervals = new Pair[3];

		intervals[0] = new Pair(0, 30);
		intervals[1] = new Pair(5, 10);
		intervals[2] = new Pair(15, 20);

		System.out.print(minMeetingRooms(intervals));
		
	}

}
