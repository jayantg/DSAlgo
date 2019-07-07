package com.tree.binary;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
    private Node root;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public static BinaryTree buildTestTree(){
        BinaryTree tree = new BinaryTree();
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        Node seven = new Node(7);
        tree.setRoot(one);
        one.setLeft(two);
        one.setRight(three);
        two.setLeft(four);
        two.setRight(five);
        three.setLeft(six);
        three.setRight(seven);
        return tree;
    }

    public void insert(Node node){
        if (root == null) {
            root = node;
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        Node current = null;
        while (!queue.isEmpty()){
            current = queue.poll();
            if (current.getLeft() != null) {
                queue.offer(current.getLeft());
            }else {
                current.setLeft(node);
                break;
            }
            if (current.getRight() != null) {
                queue.offer(current.getRight());
            }else {
                current.setRight(node);
                break;
            }
        }
    }

    public void preOrder() {
        Stack<Node> stack = new Stack<>();
        Node current = root;

        while (true){
            while (current!=null){
                current.print();
                stack.push(current);
                current = current.getLeft();
            }
            if(stack.isEmpty()){
                break;
            }
            current = stack.pop().getRight();
        }
    }

    public void inOrder(){
        Stack<Node> stack = new Stack<>();
        Node current = root;
        while (true){
            while (current!=null){
                stack.push(current);
                current = current.getLeft();
            }
            if(stack.isEmpty()){
                break;
            }
            current = stack.pop();
            current.print();
            current = current.getRight();
        }
    }

    public void postOrder() {
        Stack<Node> stack = new Stack<>();
        Node current = root;
        while (true){
            while (current!=null){
                stack.push(current);
                current = current.getLeft();
            }
            if (stack.isEmpty()) {
                break;
            }
            current = stack.peek();
            if (current.getRight() == null) {
                current.print();
                stack.pop();
                while (!stack.isEmpty() && current.equals(stack.peek().getRight())){
                    current = stack.pop();
                    current.print();
                }
                current = null;
            }else {
                current = current.getRight();

            }
        }
    }

    public void levelOrder() {
        if (root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        Node current = null;
        queue.offer(root);
        while (!queue.isEmpty()){
            current = queue.poll();
            current.print();
            if (current.getLeft() != null) {
                queue.offer(current.getLeft());
            }
            if (current.getRight() != null) {
                queue.offer(current.getRight());
            }
        }
    }
}
