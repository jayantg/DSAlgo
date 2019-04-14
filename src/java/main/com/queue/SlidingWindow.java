package com.queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/queries-with-fixed-length/problem
 *
 * It seems more than O(n) at first look. If we take a closer look, we can observe that every element
 * of array is added and removed at most once. So there are total 2n operations.
 */
public class SlidingWindow {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int q = s.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = s.nextInt();
        }
        for(int j=0;j<q;j++){
            System.out.println(min(n,arr, s.nextInt()));
        }
        s.close();
    }

    private static int min(int n, int[] arr, int d) {
        int min = Integer.MAX_VALUE;
        int i=0;
        Deque<Integer> q = new LinkedList<>();
        /* Process first d (or first window) elements of array */
        for(;i<d; ++i){
            // For very element, the previous smaller elements are useless so
            // remove them from q
            while(!q.isEmpty() && arr[i] > arr[q.peekLast()]){
                q.pollLast(); // Remove from rear
            }
            // Add new element at rear of queue
            q.addLast(i);
        }
        // Process rest of the elements, i.e., from arr[d] to arr[n-1]
        for(;i<n;++i){
            // The element at the front of the queue is the largest element of
            // previous window, so compare it with min
            if(!q.isEmpty() && min > arr[q.peekFirst()]){
                min=arr[q.peekFirst()];
            }
            // Remove the elements which are out of this window
            while(!q.isEmpty() && q.peekFirst() <= i-d){
                q.pollFirst();
            }
            // Remove all elements smaller than the currently
            // being added element (remove useless elements)
            while(!q.isEmpty() && arr[i] > arr[q.peekLast()]){
                q.pollLast();
            }
            // Add current element at the rear of q
            q.addLast(i);
        }
        if(!q.isEmpty() && min > arr[q.peekFirst()]){
            min=arr[q.peekFirst()];
        }
        return min;
    }

}