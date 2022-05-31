package sorting;

public class QuickSort {

	public static void quickSort(int[] arr, int start, int end) {
		if (start < end) {
			int qindex = partition(arr, start, end);
			quickSort(arr, start, qindex - 1);
			quickSort(arr, qindex + 1, end);
		}
	}

	public static int partition(int[] arr, int start, int end) {
		int pivot = arr[end];
		int partitionIndex = start;

		for (int i = start; i < end; i++) {
			if (arr[i] <= pivot) {
				int temp = arr[i];
				arr[i] = arr[partitionIndex];
				arr[partitionIndex] = temp;
				partitionIndex++;
			}
		}
		
		arr[end] = arr[partitionIndex];
		arr[partitionIndex] = pivot;

		return partitionIndex;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 8, 6, 5, 4, 9, 3 };

		quickSort(arr, 0, arr.length - 1);
 
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
	}
	
}
