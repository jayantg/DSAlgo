package com.sorting;

public class CountingSort {

	public static void main(String[] args) {
		int[] arr = {1,4,1,2,7,5,2};
		int[] sorted = countingSort(arr);
		for(int i=0; i<sorted.length; i++) {
			System.out.println(sorted[i]);
		}
	}

	private static int[] countingSort(int[] arr) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for(int i=0;i<arr.length; i++) {
			min = arr[i] > min ? min : arr[i];
			max = arr[i] > max ? arr[i] : max;
		}
		
		int[] count = new int[max-min+1];
		for(int i=0; i<arr.length; i++) {
			count[arr[i] - min] ++;
		}
		
		for(int i=1; i<count.length; i++) {
			count[i] = count[i] + count[i-1];
		}
		
		int[] sorted = new int[arr.length];
		for(int i=0; i<arr.length; i++) {
			sorted[count[arr[i]-min]-1] = arr[i];
			count[arr[i]-min] --;
		}
		return sorted;
	}

}
