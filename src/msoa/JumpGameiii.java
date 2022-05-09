package msoa;

public class JumpGameiii {

	int[] visited;

	public boolean canReach(int[] arr, int start) {
		visited = new int[arr.length];
		return can(arr, start);
	}

	public boolean can(int[] arr, int start) {
		if (start < 0 || start >= arr.length)
			return false;
		if (arr[start] == 0)
			return true;
		if (visited[start] == 2 || visited[start] == 1)
			return false;
		visited[start] = 1;
		boolean right = can(arr, start + arr[start]);
		boolean left = can(arr, start - arr[start]);
		visited[start] = 0;
		if (!right && !left)
			visited[start] = 2;
		return right || left;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JumpGameiii obj = new JumpGameiii();
		int [] arr = {3, 4, 2, 3, 0, 3, 1, 2, 1};
		int start = 7;
		
		System.out.print(obj.canReach(arr,start));
		
		
	}

}
