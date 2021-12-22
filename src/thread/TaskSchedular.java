package thread;

/**
 * 
 * https://www.youtube.com/watch?v=eGf-26OTI-A (Task Schedular)
 * 
 * @author nishant.chauhan
 * 
 */

import java.util.Arrays;

public class TaskSchedular {

	private static int leastInterval(char[] task, int n) {

		int[] char_map = new int[26];

		for (char c : task) {
			char_map[c - 'A']++;
		}

		Arrays.sort(char_map); // only fix 26 alpha not create extra complixity

		int max_value = char_map[25] - 1; // because not care for last interval(check Nick White)

		int idle_slot = max_value * n;

		for (int i = 24; i > 0; i--) {
			idle_slot -= Math.min(char_map[i], max_value); // you have to fill up remaning spaces.
		}

		return idle_slot > 0 ? idle_slot + task.length : task.length;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		char[] task = { 'A', 'A', 'A', 'B', 'B', 'B' };
		int cooling_interval = 2;

		System.out.print(leastInterval(task, cooling_interval));
	}

}
