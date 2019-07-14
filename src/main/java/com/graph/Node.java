package com.graph;

public class Node {

    private char data;
    private Node next;
    private int weight;

    public Node(char data) {
        this.data = data;
    }

    public Node(char data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    public char getData() {
        return data;
    }

    public void setData(char data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

}
