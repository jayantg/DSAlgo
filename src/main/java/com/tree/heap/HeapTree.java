package com.tree.heap;

import com.tree.binary.Node;

/**
 * It is a tree with below properties
 * 1. Every node must be >= or <= to their children values
 * 2. It should be complete tree i.e every leaf node should be at level h or h-1. Height of tree is h
 */
public class HeapTree {

    private int[] arr;
    private int size;
    private int capacity;

    public HeapTree(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.arr = new int[capacity];
    }

    public HeapTree(int[] arr) {
        this.arr = arr;
        this.size = arr.length - 1;
        this.capacity = arr.length;
    }

    public static void main(String[] args) {
        int[] arr = {17,13,6,1,4,2,5};
        HeapTree tree = buildHeap(arr);
        tree.print(0);
        System.out.println("\nDelete element ");
        tree.deleteMax();
        tree.print(0);
        System.out.println("\nInsert element");
        tree.insert(17);
        tree.print(0);
    }

    public static HeapTree buildHeap(int[] arr){
        HeapTree tree = new HeapTree(arr);
        int size = arr.length - 1;
        for (int i = size; i >= 0; i--) {
            tree.percolateDown(i);
        }
        return tree;
    }

    /**
     *
     * @param i
     * @return parent for child index i
     */
    public int parent(int i){
        if(i<0 || i>size){
            return -1;
        }
        return (i-1)/2;
    }

    /**
     *
     * @param i
     * @return left index for parent index i
     */
    public int left(int i){
        if(i<0 || i>size){
            return -1;
        }
        int left = (2*i) + 1;
        return left > size ? -1 : left;
    }

    /**
     *
     * @param i
     * @return right index for parent index i
     */
    public int right(int i){
        if(i<0 || i>size){
            return -1;
        }
        int right = (2*i) + 2;
        return right>size?-1:right;
    }

    public int deleteMax(){
        if(size==0){
            return -1;
        }
        int data = arr[0];
        arr[0] = arr[size];
        arr[size] = 0;
        size = size - 1;
        percolateDown(0);
        return data;
    }

    public void insert(int data){
        size = size + 1;
        if(size>=capacity){
            increaseCapacity();
        }
        arr[size] = data;
        percolateUp(size);
    }

    public void percolateDown(int i){
        if(i<0 || i>size){
            return;
        }
        int leftIndex = left(i);
        int rightIndex = right(i);
        int index = i;

        if(leftIndex != -1 && arr[leftIndex]>arr[index]){
            index = leftIndex;
        }
        if(rightIndex != -1 && arr[rightIndex]> arr[index]){
            index = rightIndex;
        }
        if(index == i){
            return;
        }

        int temp = arr[i];
        arr[i] = arr[index];
        arr[index] = temp;
        percolateDown(index);
    }

    private void percolateUp(int i) {
        if(i<0 || i>size){
            return;
        }
        int parentIndex = parent(i);
        if(arr[parentIndex] < arr[i]){
            int temp = arr[parentIndex];
            arr[parentIndex] = arr[i];
            arr[i] = temp;
            percolateUp(parentIndex);
        }
    }

    private void increaseCapacity() {
        int newCapacity = capacity * 2;
        int[] newArr = new int[newCapacity];
        for (int i = 0; i < size; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
    }

    private void print(int index){
        if(index<0 || index>size){
            return;
        }
        System.out.print(arr[index] + " ");
        print(left(index));
        print(right(index));
    }

    public int[] getArr() {
        return arr;
    }

    public void setArr(int[] arr) {
        this.arr = arr;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
