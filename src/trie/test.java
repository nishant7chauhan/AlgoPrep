package trie;

import java.time.LocalTime;

public class test {

	int i = 0;
	public void abc(int i) {
		abc1(i);
		
		System.out.println(i);
	}
	public void abc1(int i) {
		i++;
		
	}

	public static void main(String[] args) {
		String s = "08:30:00";
		test t = new test();
		LocalTime lt = LocalTime.parse(s);

		
		t.abc(0);
		
	}
}
