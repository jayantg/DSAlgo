package com.stack.geeks.practice;

import java.util.Scanner;
import java.util.Stack;

/**
 * https://practice.geeksforgeeks.org/problems/smallest-number-on-left/0
 *
 * Given an array of integers, find the nearest smaller number for every element such that the smaller element is on left side.If no small element present on the left print -1.
 *
 * Input:
 *
 * The first line of input contains T test cases.
 *
 * The first line of each test case contains the number of elements in the array.
 *
 * The second line of each test case contains the elements of the array.
 *
 * Output:
 *
 * Print the n elements.
 * Constraints:
 *
 * 1<=T<=100
 *
 * 1<=N<=100
 *
 * 0<=A[i]<10000
 * Example:
 *
 * Input:
 *
 * 2
 *
 * 3
 *
 * 1 6 2
 *
 * 6
 *
 * 1 5 0 3 4 5
 *
 * Output:
 *
 * -1 1 1
 *
 * -1 1 -1 0 3 4
 */
public class NearestSmallestNumberOnLeft {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTest = scanner.nextInt();
        for (int i = 0; i < numberOfTest; i++) {
            int numberOfElements = scanner.nextInt();
            int[] arr = new int[numberOfElements];
            for (int j = 0; j < numberOfElements; j++) {
                arr[j] = scanner.nextInt();
            }
            smallestNumberOnLeft(arr);
        }
    }

    private static void smallestNumberOnLeft(int[] arr) {
        Stack<Integer> s = new Stack<>();
        for (int a : arr) {
            while (!s.isEmpty() && s.peek()> a){
                s.pop();
            }
            if (s.isEmpty()){
                System.out.print( -1 + " ");
            } else{
                System.out.print(s.peek() + " ");
            }
            s.push(a);
        }
    }
}
