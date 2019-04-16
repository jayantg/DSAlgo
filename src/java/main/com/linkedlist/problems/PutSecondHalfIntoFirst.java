package com.linkedlist.problems;

import com.linkedlist.ListNode;
import com.linkedlist.Single.SingleLinkedList;

/**
 * Odd Example
 * list : 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> null
 * Expected : 1 -> 9 -> 2 -> 8 -> 3 -> 7 -> 4 -> 6 -> 5 -> null
 *
 * Even Example
 * list : 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> 10 -> null
 * Expected : 1 -> 10 -> 2 -> 9 -> 3 -> 8 -> 4 -> 7 -> 5 -> 6 -> null
 *
 */
public class PutSecondHalfIntoFirst {

    public static void main(String[] args) {
        //even
        SingleLinkedList evenList = new SingleLinkedList();
        for (int i = 1; i < 11; i++) {
            evenList.insert(i);
        }
        evenList.printList();
        putSecondHalfIntoFirst(evenList.getRoot());
        evenList.printList();

        //odd
        SingleLinkedList oddList = new SingleLinkedList();
        for (int i = 1; i < 10; i++) {
            oddList.insert(i);
        }
        oddList.printList();
        putSecondHalfIntoFirst(oddList.getRoot());
        oddList.printList();
    }

    private static void putSecondHalfIntoFirst(ListNode root) {
        ListNode slow = root; ListNode fast = root;
        ListNode next = null; ListNode previous = null;
        ListNode current = root;
        boolean even = true;
        /**
         * Move till half of list (slow 1 step and fast 2 steps)
         * Reverse first half string
         */
        while (fast != null){
            slow = slow.getNext();
            fast = fast.getNext();

            next = current.getNext();
            current.setNext(previous);
            previous = current;
            current = next;

            if(fast == null){
                even = false;
                break;
            }else{
                fast = fast.getNext();
            }
        }
        fast = current;
        slow = previous;
        next = previous.getNext();

        /**
         * Even : point to first element of second half
         * Odd : point to null
         */
        if(even){
            slow.setNext(current);
            fast = current.getNext();
            current.setNext(null);
        }else{
            slow.setNext(null);
        }
        /**
         * Put second half values into first half
         */
        while (fast != null){
            current = fast;
            fast = current.getNext();
            previous = next.getNext();
            next.setNext(current);
            current.setNext(slow);
            slow = next;
            next = previous;
        }
    }


}
