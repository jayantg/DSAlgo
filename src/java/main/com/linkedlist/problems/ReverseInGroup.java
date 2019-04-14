package com.linkedlist.problems;

import com.linkedlist.ListNode;
import com.linkedlist.Single.SingleLinkedList;

/**
 * https://www.geeksforgeeks.org/reverse-a-list-in-groups-of-given-size/
 */
public class ReverseInGroup {
    public static void main(String[] args){
        SingleLinkedList list = new SingleLinkedList();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        list.insert(6);
        list.insert(7);
        list.insert(8);
        list.insert(9);

        list.printList();

        ListNode root = reverse(list.getRoot(), 3);

        list.printList(root);
    }

    private static ListNode reverse(ListNode root, int k){
        ListNode current = root;
        ListNode previous = null;
        ListNode next = null;
        int i =0;
        while (i<k && current != null ){
            next = current.getNext();
            current.setNext(previous);
            previous = current;
            current = next;
            i++;
        }

        if(current != null ){
            root.setNext(reverse(current,k));
        }
        return previous;
    }

}
