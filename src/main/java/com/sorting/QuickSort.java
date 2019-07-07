package com.sorting;

public class QuickSort {

	public static void main(String[] args) {
		int[] arr = {2,34,1,5,3,45,21,11,15};
		quickSort(arr, 0, arr.length -1);
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	
	public static void quickSort(int[] arr, int start, int end) {
		while(end>start) {
			int pivot = partition(arr, start, end);
			quickSort(arr, start, pivot - 1);
			quickSort(arr, pivot + 1, end);
		}
	}

	private static int partition(int[] arr, int start, int end) {
		int pivot = start;
		int temp;
		while(start<end) {
			while(arr[start] <= arr[pivot]) {
				start ++;
			}
			while(arr[end] > arr[pivot]) {
				end --;
			}
			if(start<end) {
				temp = arr[start];
				arr[start] = arr[end];
				arr[end] = temp;
			}
		}
		temp = arr[end];
		arr[end] = arr[pivot];
		arr[pivot] = temp;
		
		return end;
	}

}
