package com.tree.heap;

public class HeapSort {
    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        int[] arr = {4,2,6,8,1,3,7,9};
        System.out.println("Array");
        heapSort.print(arr);

        HeapTree tree = HeapTree.buildHeap(arr);
        System.out.println("Heap array");
        heapSort.print(tree.getArr());

        tree = sort(tree);
        System.out.println("After sorting");
        heapSort.print(tree.getArr());
    }

    public static HeapTree sort(HeapTree tree) {
        int oldSize = tree.getSize();
        for (int i = 0; i < tree.getCapacity(); i++) {
            int temp = tree.getArr()[tree.getSize()];
            tree.getArr()[tree.getSize()] = tree.getArr()[0];
            tree.getArr()[0] = temp;
            tree.setSize(tree.getSize() - 1);
            tree.percolateDown(0);
        }
        tree.setSize(oldSize);
        return tree;
    }

    private void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
