package com.tree.heap;

import java.util.Arrays;
import java.util.Random;

public class Max10FromFileWithBillons {
    public static void main(String[] args) {
        Max10FromFileWithBillons app = new Max10FromFileWithBillons();
        int[] arr = app.readNextFromFile(1000);
        HeapTree tree = HeapTree.buildHeap(arr);
        int[] top10 = new int[10];
        for (int i = 0; i < 10; i++) {
            top10[i] = tree.deleteMax();
        }
        for (int i = 0; i < 10000000; i++) {
            top10 = app.operation(top10);
        }
        app.print(top10);
    }

    private int[] operation(int[] top10){
        int[] arr = readNextFromFile(990);
        arr = merge(top10, arr);
        HeapTree tree = HeapTree.buildHeap(arr);
        top10 = new int[10];
        for (int i = 0; i < 10; i++) {
            top10[i] = tree.deleteMax();
        }
        return top10;
    }
    private int[] merge(int[] top10, int[] arr) {
        int[] merged = Arrays.copyOf(arr, 1000);
        for (int i = 0; i < top10.length; i++) {
            merged[990 + i] = top10[i];
        }
        return merged;
    }

    private int[] readNextFromFile(int size){
        Random random = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt();
        }
        return arr;
    }

    private void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
