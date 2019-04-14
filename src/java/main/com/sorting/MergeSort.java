package com.sorting;

/**
 * 
 * @author jayantg
 *
 */
public class MergeSort {

	public static void main(String[] args) {
		int[] arr = {2,34,1,5,3,45,21,11,15};
		mergeSort(arr, new int[arr.length], 0, arr.length -1);
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	public static void mergeSort(int[] arr, int[] temp, int start, int end) {
		if(end>start) {
			int mid = (start + end)/2;
			mergeSort(arr, temp, start, mid);
			mergeSort(arr, temp, mid+1, end);
			merge(arr,temp,start,mid,end);
		}
	}

	private static void merge(int[] arr, int[] temp, int start, int mid, int end) {
		int i = start;
		int j = mid + 1;
		int k = start;
		
		while(i<=mid && j<= end) {
			if(arr[i]> arr[j]) {
				temp[k] = arr[j];
				j++;
			}else {
				temp[k] = arr[i];
				i++;
			}
			k++;
		}
		
		while(i<=mid) {
			temp[k] = arr[i];
			k++;i++;
		}
		
		while(j<=end) {
			temp[k] = arr[j];
			k++;j++;
		}
		
		for(k=start;k<=end;k++) {
			arr[k] = temp[k];
		}
	}
}
