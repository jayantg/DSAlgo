package com.linkedlist.problems;

import com.linkedlist.ListNode;
import com.linkedlist.Single.SingleLinkedList;

import java.util.LinkedList;
import java.util.Stack;

/**
 * https://www.geeksforgeeks.org/swap-kth-node-from-beginning-with-kth-node-from-end-in-a-linked-list/
 *
 * Original Linked List: 1 2 3 4 5 6 7 8
 *
 * Modified List for k = 1
 * 8 2 3 4 5 6 7 1
 *
 * Modified List for k = 2
 * 8 7 3 4 5 6 2 1
 *
 * Modified List for k = 3
 * 8 7 6 4 5 3 2 1
 *
 * Modified List for k = 4
 * 8 7 6 5 4 3 2 1
 *
 * Modified List for k = 5
 * 8 7 6 4 5 3 2 1
 *
 * Modified List for k = 6
 * 8 7 3 4 5 6 2 1
 *
 * Modified List for k = 7
 * 8 2 3 4 5 6 7 1
 *
 * Modified List for k = 8
 * 1 2 3 4 5 6 7 8
 *
 */
public class SwapNodeStartWithEnd {
    public static void main(String[] args) {
        for (int k = 1; k < 9; k++) {
            System.out.println("______________________________________________________");
            System.out.println("k = " + k);
            SingleLinkedList list = getList(8);
            swap(list, k);
        }
    }

    private static SingleLinkedList getList(int size){
        SingleLinkedList list = new SingleLinkedList();
        for (int i = 0; i < size; i++) {
            list.insert(i+1);
        }
        System.out.print("Original List :");
        list.printList();
        return list;
    }

    private static void swap(SingleLinkedList list, int k) {
        int size = list.length();
        if(k>size || k<0 || 2*k == size) return;
        k = k*2 > size ? size - k : k;

        ListNode root = list.getRoot();
        Stack<ListNode> stack = new Stack<>();
        //Push first k element into stack.
        ListNode node = root;
        for (int i = 0; i < k ; i++) {
            stack.push(node);
            node = node.getNext();
        }

        ListNode fast = node;
        ListNode slow = root;
        //Move slow pointer to starting of last k element
        while(fast.getNext() != null){
            slow = slow.getNext();
            fast = fast.getNext();
        }
        fast = node;
        node = slow.getNext();
        //Add first k element at the end of list in reverse order
        while (!stack.isEmpty()){
            slow.setNext(stack.pop());
            slow = slow.getNext();
        }
        slow.setNext(null);
        //Push last k element in to stack
        while (node != null){
            stack.push(node);
            node = node.getNext();
        }
        //Add last element at the start of list in reverse order
        if(!stack.isEmpty()){
            root = stack.peek();
            node = stack.pop();
            while (!stack.isEmpty()){
                node.setNext(stack.pop());
                node = node.getNext();
            }
            node.setNext(fast);
        }

        System.out.print("Modified List :");
        list.setRoot(root);
        list.printList();
    }
}
