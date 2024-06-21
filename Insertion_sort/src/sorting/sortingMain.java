package sorting;

import java.util.Arrays;

public class sortingMain {

	public static void insertionSort(int[] arr) {
		//n-1 passes in each consider ith element as last element of array
		for(int i=1;i<arr.length;i++) {
			//copy last element into temp var
		int j,temp=arr[i];
		//compare temp will all elements before that ,find appropriate position for the element and insert into temp position
		for(j=i-1; j>=0 && arr[j]>temp; j--) {
			 arr[j+1]=arr[j];
		}
		arr[j+1]=temp;
	}
}
	public static void main(String[] args) {
		int []arr= {6,4,2,8,3,1};
		System.out.println("Insertion sort");
		System.out.println("Before"+Arrays.toString(arr));
		insertionSort(arr);
		System.out.println("Aftre"+Arrays.toString(arr));
		

	}

}
