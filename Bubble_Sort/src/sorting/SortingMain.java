package sorting;

import java.util.Arrays;

public class SortingMain {

	public static void bubbleSort(int[] arr) {
		for(int i=0; i<arr.length-1; i++) {
			for(int j=0;j<arr.length-1; j++) {
				if(arr[j]>arr[j+1]) {
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
	}
	public static void main(String[] args) {
		int []arr= {6,4,2,8,3,1};
		System.out.println("Bubble sort");
		System.out.println("Before"+Arrays.toString(arr));
		bubbleSort(arr);
		System.out.println("After"+Arrays.toString(arr));

	}

}
