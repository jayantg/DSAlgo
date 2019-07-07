package com.stack.geeks.practice;

public class MaxOfMinForEveryWindowSize {
    public static void main(String[] args) {
        int[] arr1 = {10, 20, 30, 50, 10, 70, 30};
        maxOfMinForEveryWindowSize(arr1);
        int[] arr2 = {10, 20, 30};
        maxOfMinForEveryWindowSize(arr2);
    }

    private static void maxOfMinForEveryWindowSize(int[] arr) {
        System.out.println();
        int[] temp = new int[arr.length];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
            max = max>temp[i] ? max:temp[i];
        }
        System.out.print(max + " ");

        for (int i = 1; i < arr.length; i++) {
            max = Integer.MIN_VALUE;
            for (int j=0; j<arr.length; j++){
                if((j + i) >= arr.length){
                    break;
                }
                temp[j] = temp[j] > arr[j+i]? arr[j+i] : temp[j];
                max = max>temp[j] ? max:temp[j];
            }
            System.out.print(max + " ");
        }
    }
}
