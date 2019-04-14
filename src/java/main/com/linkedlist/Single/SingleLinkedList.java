package com.linkedlist.Single;

import com.linkedlist.ListNode;

public class SingleLinkedList {
    private ListNode root;

    public ListNode getRoot() {
        return root;
    }

    public void setRoot(ListNode root) {
        this.root = root;
    }

    /**
     * Print list
     */
    public void printList(){
        System.out.println();
        ListNode current = root;
        while(current != null ){
            System.out.print(current.getData() + " -> ");
            current= current.getNext();
        }
        System.out.println("null");
    }

    /**
     *
     * @param current
     */
    public void printList(ListNode current){
        System.out.println();
        while(current != null ){
            System.out.print(current.getData() + " -> ");
            current= current.getNext();
        }
        System.out.println("null");
    }

    /**
     * Return list length
     * @return
     */
    public int length(){
        int length = 0;
        ListNode current = root;
        while(current != null){
            length=length++;
            current = current.getNext();
        }
        return length;
    }

    /**
     * Insert at last position
     * @param data
     */
    public void insert(int data){
        ListNode node = new ListNode(data);
        if (root == null) {
            root = node;
        }else{
            ListNode previous = root;
            while(previous.getNext() != null){
                previous = previous.getNext();
            }
            previous.setNext(node);
        }
    }
}
