package array;
import java.util.Comparator;
import java.util.PriorityQueue;


/**
 * Given a stream of input Integers, at any time get the median of those numbers
 * https://www.youtube.com/watch?v=VmogG01IjYc
 * @author IN006166
 * O(NlogN)
 */



public class MedianInStream {

	private static void addNumbers(int number, PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
		// TODO Auto-generated method stub

		if (lowers.size() == 0 || number < lowers.peek()) {
			lowers.add(number);
		} else {
			highers.add(number);
		}

	}

	private static void rebalance(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
		// TODO Auto-generated method stub
		PriorityQueue<Integer> biggerHeap = lowers.size() > highers.size() ? lowers : highers;
		PriorityQueue<Integer> smallerHeap = lowers.size() > highers.size() ? highers : lowers;

		if (biggerHeap.size() - smallerHeap.size() >= 2) {
			smallerHeap.add(biggerHeap.poll());
		}

	}

	private static double gerMedian(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
		PriorityQueue<Integer> biggerHeap = lowers.size() > highers.size() ? lowers : highers;
		PriorityQueue<Integer> smallerHeap = lowers.size() > highers.size() ? highers : lowers;

		if (biggerHeap.size() == smallerHeap.size()) {
			return ((double) biggerHeap.peek() + smallerHeap.peek()) / 2;
		} else {
			return biggerHeap.peek();
		}

	}

	public static void getmedians(int[] array) {

		PriorityQueue<Integer> lowers = new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return -1 * o1.compareTo(o2);
			}
		});

		PriorityQueue<Integer> highers = new PriorityQueue<Integer>();

		for (int i = 0; i < array.length; i++) {

			int number = array[i];
			addNumbers(number, lowers, highers);
			rebalance(lowers, highers);
			System.out.println("Median after reading " + array[i] + ": " + gerMedian(lowers, highers));

		}

	}

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5 };
		getmedians(arr);
	}
}
