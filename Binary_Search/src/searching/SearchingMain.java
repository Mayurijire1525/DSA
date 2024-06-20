package searching;

import java.util.Arrays;
import java.util.Scanner;

public class SearchingMain {

	public static int BinarySearch(int[] arr,int key) {
		int left=0,right=arr.length,mid;
		while(left<=right) {
		mid=(left+right)/2;
		if(key==arr[mid])
			return mid;
		if(key<arr[mid])
			right=mid-1;
		else
			left=mid+1;
		
	}
		return -1;
}
	public static int recBinarySearch(int[] arr,int left,int right,int key) {
		if(right<left)
			return -1;
		int index, mid=(left+right)/2;
		if(key==arr[mid])
			return mid;
		if(key<arr[mid])
			index=recBinarySearch(arr,left,mid-1,key);
		else
			index=recBinarySearch(arr,left,mid-1,key);
		return index;
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int []arr= {88,33,66,99,44,77,22,55,11};
		Arrays.sort(arr);
		System.out.println("Enter key to search");
		int key=sc.nextInt();
		//only on sorted array
		int index=BinarySearch(arr,key);
		if(index!=-1)
			System.out.println("Key found at index "+index);
		else
			System.out.println("Key not found");
		int index1=recBinarySearch(arr,0,arr.length-1,key);
		if(index!=-1)
			System.out.println("Key found at index "+index);
		else
			System.out.println("Key not found");
	}

}