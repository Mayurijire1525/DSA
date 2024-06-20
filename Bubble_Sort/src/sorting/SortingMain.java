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
	public static void impbubbleSort(int[] arr1) {
		for(int i=0; i<arr1.length-1; i++) {
			for(int j=0;j<arr1.length-1-i; j++) {
				if(arr1[j]>arr1[j+1]) {
					int temp=arr1[j];
					arr1[j]=arr1[j+1];
					arr1[j+1]=temp;
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
		
		System.out.println("Bubble sort");
		int []arr1= {7,5,1,9,4,2};
		System.out.println("Before"+Arrays.toString(arr1));
		impbubbleSort(arr1);
		System.out.println("After"+Arrays.toString(arr1));

	}

}
