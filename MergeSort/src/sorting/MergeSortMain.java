package sorting;

import java.util.Arrays;

public class MergeSortMain {

    public static void mergeSort(int[] arr, int left, int right) {
        // If partition is invalid or has a single element then return
        if (left >= right) {
            return;
        }
        // Divide array into two equal partitions
        int mid = (left + right) / 2;
        
        // Sort left partition [left to mid]
        mergeSort(arr, left, mid);
        
        // Sort right partition [mid+1 to right]
        mergeSort(arr, mid + 1, right);
        
        // Create temp array to accommodate both partitions 
        int[] temp = new int[right - left + 1];
        
        // Merge two sorted partitions into temp array
        int i = left, j = mid + 1, k = 0;
        
        // Compare elements from both partitions and copy the smaller one (until any one partition is done)
        while (i <= mid && j <= right) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
    
        // Copy remaining elements from other partition
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= right) {
            temp[k++] = arr[j++];
        }
        
        // Overwrite temp array back to original array
        for (i = 0; i < temp.length; i++) {
            arr[left + i] = temp[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = {8, 3, 9, 1, 5, 7, 2, 6, 4};
        System.out.println("Original array: " + Arrays.toString(arr));
        mergeSort(arr, 0, arr.length - 1);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}
