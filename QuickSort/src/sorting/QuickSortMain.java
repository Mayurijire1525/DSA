package sorting;

import java.util.Arrays;

public class QuickSortMain {

	public static int partition(int arr[], int low, int high) {
		int pivot = arr[high];
		int i = low - 1;
		for (int j = low; j < high; j++) {
			if (arr[j] <= pivot) {
				i++;
				// Swap arr[i] and arr[j]
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		// Swap arr[i+1] and arr[high] (or pivot)
		int temp = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp;
		return i + 1;
	}

	public static void quicksort(int arr[], int low, int high) {
		if (low < high) {
			int pindex = partition(arr, low, high);
			quicksort(arr, low, pindex - 1);
			quicksort(arr, pindex + 1, high);
		}
	}

	public static void main(String[] args) {
		int[] arr = { 6, 3, 9, 5, 2, 8 };
		System.out.println("Original array: " + Arrays.toString(arr));
		int n = arr.length;
		quicksort(arr, 0, n - 1);
		System.out.println("Sorted array: " + Arrays.toString(arr));
	}
}
